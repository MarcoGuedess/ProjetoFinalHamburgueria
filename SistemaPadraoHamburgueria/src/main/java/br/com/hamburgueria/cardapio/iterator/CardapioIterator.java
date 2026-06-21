package br.com.hamburgueria.cardapio.iterator;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.dominio.ItemPedido;

import java.util.Iterator;
import java.util.List;

// Pattern 16: Iterator
public class CardapioIterator implements Iterator<ItemPedido> {
    private List<ItemPedido> itens;
    private int posicao = 0;

    public CardapioIterator(List<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public boolean hasNext() {
        return posicao < itens.size() && itens.get(posicao) != null;
    }

    @Override
    public ItemPedido next() {
        ItemPedido item = itens.get(posicao);
        posicao++;
        return item;
    }
}


