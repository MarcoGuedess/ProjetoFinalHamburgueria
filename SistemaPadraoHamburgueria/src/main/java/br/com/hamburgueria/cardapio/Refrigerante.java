package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.Bebida;
import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.dominio.Dinheiro;


public class Refrigerante extends Bebida {
    public Refrigerante() {
        this.nome = "Refrigerante Cola 350ml";
        this.preco = Dinheiro.reais(6.00);
        this.calorias = 150;
    }
}

