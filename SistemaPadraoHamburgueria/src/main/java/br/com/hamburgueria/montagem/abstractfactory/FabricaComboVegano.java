package br.com.hamburgueria.montagem.abstractfactory;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.composite.Combo;
import br.com.hamburgueria.cardapio.LancheVegano;
import br.com.hamburgueria.cardapio.Refrigerante;
import br.com.hamburgueria.montagem.abstractfactory.ComboFactory;

 // No mundo real seria SucoNatural

public class FabricaComboVegano implements ComboFactory {
    @Override
    public Combo criarCombo() {
        Combo combo = new Combo("Combo Vegano Simples", 0.10); // 10% desconto
        combo.adicionarItem(new LancheVegano());
        combo.adicionarItem(new Refrigerante());
        return combo;
    }
}


