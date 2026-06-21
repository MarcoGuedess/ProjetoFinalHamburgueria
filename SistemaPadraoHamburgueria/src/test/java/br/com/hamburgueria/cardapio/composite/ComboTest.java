package br.com.hamburgueria.cardapio.composite;

import br.com.hamburgueria.cardapio.BatataFrita;
import br.com.hamburgueria.cardapio.LancheTradicional;
import br.com.hamburgueria.cardapio.Refrigerante;
import br.com.hamburgueria.dominio.Dinheiro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComboTest {

    @Test
    public void deveCalcularPrecoDoComboComDesconto() {
        Combo combo = new Combo("Combo Teste", 0.10); // 10% de desconto
        combo.adicionarItem(new LancheTradicional()); // 25.00
        combo.adicionarItem(new Refrigerante());      // 6.00
        combo.adicionarItem(new BatataFrita());       // 12.00
        
        // Total sem desconto = 43.00
        // Desconto de 10% = 4.30
        // Total esperado = 38.70
        
        Dinheiro total = combo.getPreco();
        assertEquals(38.70, total.getQuantia().doubleValue(), 0.01);
    }

    @Test
    public void deveSomarCaloriasDosItensDoCombo() {
        Combo combo = new Combo("Combo Teste", 0.10);
        combo.adicionarItem(new LancheTradicional()); // 600
        combo.adicionarItem(new Refrigerante());      // 150
        
        assertEquals(750, combo.getCalorias());
    }
}
