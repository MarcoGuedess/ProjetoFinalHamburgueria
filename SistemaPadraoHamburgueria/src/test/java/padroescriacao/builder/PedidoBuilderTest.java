package padroescriacao.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoBuilderTest {

    @Test
    void deveRetornarExcecaoParaPedidoSemNumero() {
        try {
            new PedidoBuilder()
                    .setCliente("Tiago")
                    .setHamburguer("Classico")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Numero do pedido invalido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaPedidoSemCliente() {
        try {
            new PedidoBuilder()
                    .setNumero(1)
                    .setHamburguer("Classico")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Cliente invalido", e.getMessage());
        }
    }

    @Test
    void deveRetornarPedidoValido() {
        Pedido pedido = new PedidoBuilder()
                .setNumero(1)
                .setCliente("Tiago")
                .setHamburguer("Classico")
                .setBebida("Refrigerante")
                .setValor(32.0f)
                .build();

        assertNotNull(pedido);
        assertEquals("Classico", pedido.getHamburguer());
    }
}
