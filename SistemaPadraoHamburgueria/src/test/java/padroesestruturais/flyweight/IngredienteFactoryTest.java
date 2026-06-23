package padroesestruturais.flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredienteFactoryTest {

    @BeforeEach
    void setUp() {
        IngredienteFactory.limpar();
    }

    @Test
    void deveCompartilharIngredienteRepetido() {
        Ingrediente queijo1 = IngredienteFactory.getIngrediente("queijo");
        Ingrediente queijo2 = IngredienteFactory.getIngrediente("queijo");

        assertSame(queijo1, queijo2);
        assertEquals(1, IngredienteFactory.getQuantidadeIngredientes());
    }

    @Test
    void deveCriarIngredientesDiferentes() {
        Ingrediente queijo = IngredienteFactory.getIngrediente("queijo");
        Ingrediente bacon = IngredienteFactory.getIngrediente("bacon");

        assertNotSame(queijo, bacon);
        assertEquals("queijo", queijo.getNome());
        assertEquals("bacon", bacon.getNome());
        assertEquals(2, IngredienteFactory.getQuantidadeIngredientes());
    }

    @Test
    void deveLimparIngredientesCompartilhados() {
        IngredienteFactory.getIngrediente("queijo");
        IngredienteFactory.getIngrediente("bacon");

        IngredienteFactory.limpar();

        assertEquals(0, IngredienteFactory.getQuantidadeIngredientes());
    }
}
