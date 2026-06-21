package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.Lanche;
import br.com.hamburgueria.dominio.Dinheiro;


public class LancheVegano extends Lanche {
    public LancheVegano() {
        this.nome = "Hambúrguer Vegano de Grão de Bico";
        this.preco = Dinheiro.reais(28.00);
        this.calorias = 450;
    }
}

