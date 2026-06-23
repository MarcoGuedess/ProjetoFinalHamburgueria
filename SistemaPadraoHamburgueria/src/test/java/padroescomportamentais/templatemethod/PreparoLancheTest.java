package padroescomportamentais.templatemethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreparoLancheTest {

    @Test
    void devePrepararHamburguerCarne() {
        PreparoLanche preparo = new PreparoHamburguerCarne();
        assertEquals("Ingredientes separados, Carne assada, Lanche montado", preparo.preparar());
    }

    @Test
    void devePrepararHamburguerVegano() {
        PreparoLanche preparo = new PreparoHamburguerVegano();
        assertEquals("Ingredientes separados, Proteina vegetal assada, Lanche montado", preparo.preparar());
    }
}
