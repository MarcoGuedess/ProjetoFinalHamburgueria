package br.com.hamburgueria.atendimento.facade;

import br.com.hamburgueria.atendimento.memento.PedidoMemento;
import br.com.hamburgueria.config.singleton.ConfiguracaoLoja;
import br.com.hamburgueria.dominio.Cliente;
import br.com.hamburgueria.dominio.Dinheiro;
import br.com.hamburgueria.dominio.ItemPedido;
import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.montagem.builder.PedidoBuilder;
import br.com.hamburgueria.operacional.command.AcaoCaixaCommand;
import br.com.hamburgueria.operacional.command.ComandoProcessarVenda;
import br.com.hamburgueria.operacional.mediator.CentralOperacoesMediator;
import br.com.hamburgueria.pagamento.strategy.EstrategiaPagamento;
import br.com.hamburgueria.promocao.chainofresponsibility.ValidacaoPedidoChain;
import br.com.hamburgueria.promocao.chainofresponsibility.ValidarLojaAberta;
import br.com.hamburgueria.promocao.chainofresponsibility.ValidarPedidoNaoVazio;
import br.com.hamburgueria.promocao.interpreter.Expressao;
import br.com.hamburgueria.promocao.interpreter.ExpressaoCupom;

import java.util.Stack;

// Pattern 10: Façade
public class TotemAtendimentoFacade {
    private PedidoBuilder builder;
    private ValidacaoPedidoChain validador;
    private CentralOperacoesMediator central;
    private Stack<PedidoMemento> historico = new Stack<>();

    public TotemAtendimentoFacade(CentralOperacoesMediator central) {
        this.central = central;
        this.builder = new PedidoBuilder();
        
        // Montando a Chain of Responsibility
        ValidacaoPedidoChain chain = new ValidarLojaAberta();
        chain.encadear(new ValidarPedidoNaoVazio());
        this.validador = chain;
    }

    public void iniciarPedido(String nomeCliente) {
        builder = new PedidoBuilder();
        builder.comCliente(new Cliente(nomeCliente, "Mesa/Totem 01"));
        System.out.println("[TOTEM] Bem vindo, " + nomeCliente + "!");
    }

    public void adicionarItem(ItemPedido item) {
        builder.adicionarItem(item);
        historico.push(builder.construir().salvarEstado()); // Memento
        System.out.println("[TOTEM] Adicionado: " + item.getNome());
    }

    public void desfazerUltimoItem() {
        if (!historico.isEmpty()) {
            historico.pop(); // tira o estado atual
            if (!historico.isEmpty()) {
                PedidoMemento estadoAnterior = historico.peek();
                builder.construir().restaurarEstado(estadoAnterior);
                System.out.println("[TOTEM] Último item removido (Undo).");
            } else {
                builder = new PedidoBuilder(); // reset se vazio
            }
        }
    }

    public Pedido finalizarPedido(String cupom, EstrategiaPagamento pagamento) {
        Pedido pedido = builder.construir();

        if (!validador.validar(pedido)) {
            System.out.println("[TOTEM] Não foi possível prosseguir com o pedido.");
            return null;
        }

        // Interpreter
        Expressao interpretador = new ExpressaoCupom("PROMO10");
        Dinheiro total = pedido.calcularTotal();
        if (interpretador.interpretar(cupom)) {
            System.out.println("[TOTEM] Cupom aplicado! 10% de desconto.");
            total = total.subtrair(total.multiplicar(0.10));
        }

        System.out.println("[TOTEM] Total a pagar: " + total);

        if (pagamento.processarPagamento(total)) {
            // Command
            AcaoCaixaCommand venda = new ComandoProcessarVenda(pedido);
            venda.executar();
            
            // State: Novo -> Em Preparo
            pedido.getEstado().preparar(pedido);

            // Mediator aciona cozinha
            central.notificarCozinha(pedido);
            
            return pedido;
        } else {
            System.out.println("[TOTEM] Falha no pagamento.");
            return null;
        }
    }
}


