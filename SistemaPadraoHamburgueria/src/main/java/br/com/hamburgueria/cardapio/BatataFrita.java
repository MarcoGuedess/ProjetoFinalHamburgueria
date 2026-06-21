package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.Acompanhamento;
import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.dominio.Dinheiro;


public class BatataFrita extends Acompanhamento {
    public BatataFrita() {
        this.nome = "Porção de Batata Frita";
        this.preco = Dinheiro.reais(12.00);
        this.calorias = 300;
    }
}

