package br.com.hamburgueria.montagem.abstractfactory;

import br.com.hamburgueria.cardapio.BatataFrita;
import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.composite.Combo;
import br.com.hamburgueria.cardapio.LancheTradicional;
import br.com.hamburgueria.cardapio.Refrigerante;
import br.com.hamburgueria.montagem.abstractfactory.ComboFactory;


public class FabricaComboTradicional implements ComboFactory {
    @Override
    public Combo criarCombo() {
        Combo combo = new Combo("Combo Tradicional Família", 0.15); // 15% desconto
        combo.adicionarItem(new LancheTradicional());
        combo.adicionarItem(new Refrigerante());
        combo.adicionarItem(new BatataFrita());
        return combo;
    }
}


