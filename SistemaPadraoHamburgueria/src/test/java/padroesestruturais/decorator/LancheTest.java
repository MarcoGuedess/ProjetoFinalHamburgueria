package padroesestruturais.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancheTest {

    @Test
    void deveRetornarPrecoHamburguerComBacon() {
        Lanche lanche = new AdicionalBacon(new HamburguerSimples());
        assertEquals(25.0f, lanche.getPreco());
    }

    @Test
    void deveRetornarPrecoHamburguerComQueijo() {
        Lanche lanche = new AdicionalQueijo(new HamburguerSimples());
        assertEquals(23.0f, lanche.getPreco());
    }

    @Test
    void deveRetornarPrecoHamburguerComBaconEQueijo() {
        Lanche lanche = new AdicionalQueijo(new AdicionalBacon(new HamburguerSimples()));
        assertEquals(28.0f, lanche.getPreco());
    }

    @Test
    void deveRetornarDescricaoHamburguerSimples() {
        Lanche lanche = new HamburguerSimples();
        assertEquals("Hamburguer simples", lanche.getDescricao());
    }

    @Test
    void deveRetornarDescricaoHamburguerComBaconEQueijo() {
        Lanche lanche = new AdicionalQueijo(new AdicionalBacon(new HamburguerSimples()));
        assertEquals("Hamburguer simples + bacon + queijo", lanche.getDescricao());
    }
}
