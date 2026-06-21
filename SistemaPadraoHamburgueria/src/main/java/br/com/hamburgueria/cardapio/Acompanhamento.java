package br.com.hamburgueria.cardapio;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.dominio.Dinheiro;
import br.com.hamburgueria.dominio.ItemPedido;
import br.com.hamburgueria.relatorio.visitor.ItemPedidoVisitor;


public abstract class Acompanhamento implements ItemPedido {
    protected String nome;
    protected Dinheiro preco;
    protected int calorias;

    @Override
    public String getNome() { return nome; }

    @Override
    public Dinheiro getPreco() { return preco; }

    @Override
    public int getCalorias() { return calorias; }

    @Override
    public void aceitar(br.com.hamburgueria.relatorio.ItemPedidoVisitor visitor) {
        visitor.visitar(this);
    }
}

