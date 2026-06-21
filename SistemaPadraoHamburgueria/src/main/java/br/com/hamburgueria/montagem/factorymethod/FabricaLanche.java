package br.com.hamburgueria.montagem.factorymethod;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.Lanche;


// Pattern 2: Factory Method
public interface FabricaLanche {
    Lanche criarLanche();
}


