package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.BatataFrita;
import br.com.hamburgueria.cardapio.iterator.CardapioIterator;
import br.com.hamburgueria.cardapio.LancheTradicional;
import br.com.hamburgueria.cardapio.LancheVegano;
import br.com.hamburgueria.cardapio.Refrigerante;
import br.com.hamburgueria.dominio.ItemPedido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cardapio {
    private List<ItemPedido> itensDisponiveis;

    public Cardapio() {
        itensDisponiveis = new ArrayList<>();
        itensDisponiveis.add(new LancheTradicional());
        itensDisponiveis.add(new LancheVegano());
        itensDisponiveis.add(new Refrigerante());
        itensDisponiveis.add(new BatataFrita());
    }

    public void adicionarItem(ItemPedido item) {
        itensDisponiveis.add(item);
    }

    public Iterator<ItemPedido> criarIterator() {
        return new CardapioIterator(itensDisponiveis);
    }
}

