package padroesestruturais.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComboCompositeTest {

    @Test
    void deveCalcularPrecoCombo() {
        Combo combo = new Combo("Combo X-Salada");
        combo.adicionarItem(new Produto("X-Salada", 25.0f));
        combo.adicionarItem(new Produto("Batata", 10.0f));
        combo.adicionarItem(new Produto("Refrigerante", 7.0f));

        assertEquals(42.0f, combo.getPreco());
    }

    @Test
    void deveRetornarPrecoDoProdutoSimples() {
        Produto produto = new Produto("Batata", 10.0f);

        assertEquals("Batata", produto.getDescricao());
        assertEquals(10.0f, produto.getPreco());
    }

    @Test
    void deveCalcularPrecoComboComOutroCombo() {
        Combo comboBebidas = new Combo("Bebidas");
        comboBebidas.adicionarItem(new Produto("Refrigerante", 7.0f));
        comboBebidas.adicionarItem(new Produto("Suco", 8.0f));

        Combo comboCompleto = new Combo("Combo completo");
        comboCompleto.adicionarItem(new Produto("X-Bacon", 30.0f));
        comboCompleto.adicionarItem(comboBebidas);

        assertEquals(45.0f, comboCompleto.getPreco());
    }

    @Test
    void deveRetornarZeroParaComboSemItens() {
        Combo combo = new Combo("Combo vazio");

        assertEquals("Combo vazio", combo.getDescricao());
        assertEquals(0.0f, combo.getPreco());
    }
}
