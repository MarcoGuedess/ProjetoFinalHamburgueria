package padroescomportamentais.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorImpostoTest {

    @Test
    void deveCalcularImpostoHamburguer() {
        ItemPedido item = new Hamburguer(30.0f);
        assertEquals(3.0f, item.aceitar(new VisitorImposto()));
    }

    @Test
    void deveCalcularImpostoBebida() {
        ItemPedido item = new Bebida(10.0f);
        assertEquals(0.5f, item.aceitar(new VisitorImposto()));
    }
}
