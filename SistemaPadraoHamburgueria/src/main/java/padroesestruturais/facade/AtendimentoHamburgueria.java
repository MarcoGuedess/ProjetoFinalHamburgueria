package padroesestruturais.facade;

import padroescriacao.builder.Pedido;
import padroescriacao.builder.PedidoBuilder;
import padroescriacao.singleton.Estoque;
import padroesestruturais.adapter.GatewayPagamento;
import padroesestruturais.adapter.MaquinaCartaoExterna;
import padroesestruturais.adapter.PagamentoCartaoAdapter;

public class AtendimentoHamburgueria {

    public Pedido realizarPedido(int numero, String cliente, String hamburguer, float valor) {
        Estoque estoque = Estoque.getInstance();
        estoque.baixarItem("pao", 1);
        estoque.baixarItem("carne", 1);

        GatewayPagamento pagamento = new PagamentoCartaoAdapter(new MaquinaCartaoExterna());
        pagamento.pagar(valor);

        return new PedidoBuilder()
                .setNumero(numero)
                .setCliente(cliente)
                .setHamburguer(hamburguer)
                .setValor(valor)
                .build();
    }
}
