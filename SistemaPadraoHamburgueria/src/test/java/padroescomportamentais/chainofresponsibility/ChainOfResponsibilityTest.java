package padroescomportamentais.chainofresponsibility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainOfResponsibilityTest {

    @Test
    void deveProcessarPedidoPagoNoFluxoCompleto() {
        Handler atendimento = new Atendimento();
        Handler cozinha = new Cozinha();
        Handler entrega = new Entrega();

        atendimento.setProximo(cozinha);
        cozinha.setProximo(entrega);

        Pedido pedido = new Pedido("Maria", "X-Salada");
        pedido.setPago(true);

        assertEquals(
                "Atendimento registrou pedido de Maria -> Cozinha preparou X-Salada -> Entrega saiu com pedido de Maria",
                atendimento.processar(pedido)
        );
    }

    @Test
    void naoDeveProcessarPedidoSemPagamento() {
        Handler atendimento = new Atendimento();
        Pedido pedido = new Pedido("Maria", "X-Salada");

        assertEquals("Pedido aguardando pagamento", atendimento.processar(pedido));
    }

    @Test
    void devePrepararPedidoPagoQuandoFluxoTerminaNaCozinha() {
        Handler atendimento = new Atendimento();
        Handler cozinha = new Cozinha();
        atendimento.setProximo(cozinha);

        Pedido pedido = new Pedido("Joao", "X-Bacon");
        pedido.setPago(true);

        assertEquals(
                "Atendimento registrou pedido de Joao -> Cozinha preparou X-Bacon",
                atendimento.processar(pedido)
        );
        assertTrue(pedido.isPronto());
    }

    @Test
    void naoDeveEntregarPedidoNaoPronto() {
        Handler entrega = new Entrega();
        Pedido pedido = new Pedido("Maria", "X-Salada");
        pedido.setPago(true);

        assertEquals("Pedido ainda nao esta pronto para entrega", entrega.processar(pedido));
    }

    @Test
    void deveEntregarPedidoPronto() {
        Handler entrega = new Entrega();
        Pedido pedido = new Pedido("Maria", "X-Salada");
        pedido.setPronto(true);

        assertEquals("Entrega saiu com pedido de Maria", entrega.processar(pedido));
    }
}
