package padroescriacao.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerFactoryTest {

    @Test
    void deveRetornarHamburguerClassico() {
        Hamburguer hamburguer = HamburguerFactory.obterHamburguer("Classico");
        assertEquals("Hamburguer classico preparado", hamburguer.preparar());
    }

    @Test
    void deveRetornarHamburguerVegetariano() {
        Hamburguer hamburguer = HamburguerFactory.obterHamburguer("Vegetariano");
        assertEquals("Hamburguer vegetariano preparado", hamburguer.preparar());
    }

    @Test
    void deveRetornarExcecaoParaHamburguerInexistente() {
        try {
            HamburguerFactory.obterHamburguer("Frango");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Hamburguer inexistente", e.getMessage());
        }
    }
}
