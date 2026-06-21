package br.com.hamburgueria.montagem.abstractfactory;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.composite.Combo;


// Pattern 3: Abstract Factory
public interface ComboFactory {
    Combo criarCombo();
}


