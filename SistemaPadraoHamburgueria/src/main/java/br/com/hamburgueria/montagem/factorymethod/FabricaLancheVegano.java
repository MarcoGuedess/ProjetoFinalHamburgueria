package br.com.hamburgueria.montagem.factorymethod;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.Lanche;
import br.com.hamburgueria.cardapio.LancheVegano;
import br.com.hamburgueria.montagem.factorymethod.FabricaLanche;


public class FabricaLancheVegano implements FabricaLanche {
    @Override
    public Lanche criarLanche() {
        return new LancheVegano();
    }
}


