package br.com.hamburgueria.operacional.command;

import br.com.hamburgueria.dominio.Cliente;
import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.operacional.command.AcaoCaixaCommand;


public class ComandoProcessarVenda implements AcaoCaixaCommand {
    private Pedido pedido;

    public ComandoProcessarVenda(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        System.out.println("[CAIXA] Registrando venda do pedido do cliente: " + pedido.getCliente().getNome());
    }
}


