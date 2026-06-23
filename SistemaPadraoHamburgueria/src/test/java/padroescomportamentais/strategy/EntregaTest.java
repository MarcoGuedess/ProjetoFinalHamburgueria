package padroescomportamentais.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntregaTest {

    @Test
    void deveCalcularRetiradaSemFrete() {
        Entrega entrega = new Entrega();
        entrega.calcularRetirada();
        assertEquals(0.0f, entrega.getValor());
    }

    @Test
    void deveCalcularBairroProximo() {
        Entrega entrega = new Entrega();
        entrega.calcularBairroProximo();
        assertEquals(6.0f, entrega.getValor());
    }

    @Test
    void deveCalcularMotoboy() {
        Entrega entrega = new Entrega();
        entrega.calcularMotoboy(4.0f);
        assertEquals(13.0f, entrega.getValor());
    }

    @Test
    void deveRetornarExcecaoParaDistanciaInvalida() {
        try {
            Entrega entrega = new Entrega();
            entrega.calcularMotoboy(0.0f);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Distancia invalida", e.getMessage());
        }
    }
}
