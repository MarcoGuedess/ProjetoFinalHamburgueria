package br.com.hamburgueria.montagem.factorymethod;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.Lanche;
import br.com.hamburgueria.cardapio.LancheTradicional;
import br.com.hamburgueria.montagem.factorymethod.FabricaLanche;


public class FabricaLancheTradicional implements FabricaLanche {
    @Override
    public Lanche criarLanche() {
        return new LancheTradicional();
    }
}


