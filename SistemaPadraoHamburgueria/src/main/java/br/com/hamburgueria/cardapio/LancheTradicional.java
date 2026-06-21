package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.Lanche;
import br.com.hamburgueria.dominio.Dinheiro;


public class LancheTradicional extends Lanche {
    public LancheTradicional() {
        this.nome = "Hambúrguer Tradicional Bovino";
        this.preco = Dinheiro.reais(25.00);
        this.calorias = 600;
    }
}

