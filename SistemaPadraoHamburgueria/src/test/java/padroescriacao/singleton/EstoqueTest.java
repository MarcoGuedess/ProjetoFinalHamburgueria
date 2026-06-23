package padroescriacao.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueTest {

    @BeforeEach
    void setUp() {
        Estoque.getInstance().limpar();
    }

    @Test
    void deveRetornarMesmoEstoque() {
        Estoque estoque1 = Estoque.getInstance();
        Estoque estoque2 = Estoque.getInstance();
        assertSame(estoque1, estoque2);
    }

    @Test
    void deveBaixarItemEstoque() {
        Estoque estoque = Estoque.getInstance();
        estoque.adicionarItem("carne", 5);
        estoque.baixarItem("carne", 2);
        assertEquals(3, estoque.getQuantidade("carne"));
    }

    @Test
    void deveRetornarExcecaoParaEstoqueInsuficiente() {
        try {
            Estoque estoque = Estoque.getInstance();
            estoque.adicionarItem("pao", 1);
            estoque.baixarItem("pao", 2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Estoque insuficiente", e.getMessage());
        }
    }
}
