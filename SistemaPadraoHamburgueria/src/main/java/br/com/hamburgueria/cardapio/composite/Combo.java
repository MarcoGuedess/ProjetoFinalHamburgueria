package br.com.hamburgueria.cardapio.composite;

import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.dominio.Dinheiro;
import br.com.hamburgueria.dominio.ItemPedido;
import br.com.hamburgueria.relatorio.visitor.ItemPedidoVisitor;


import java.util.ArrayList;
import java.util.List;

// Pattern 8: Composite
public class Combo implements ItemPedido {
    private String nome;
    private List<ItemPedido> itens = new ArrayList<>();
    private double descontoPercentual;

    public Combo(String nome, double descontoPercentual) {
        this.nome = nome;
        this.descontoPercentual = descontoPercentual;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public Dinheiro getPreco() {
        Dinheiro total = Dinheiro.reais(0.0);
        for (ItemPedido item : itens) {
            total = total.somar(item.getPreco());
        }
        // Aplica o desconto do combo
        return total.subtrair(total.multiplicar(descontoPercentual));
    }

    @Override
    public int getCalorias() {
        int totalCalorias = 0;
        for (ItemPedido item : itens) {
            totalCalorias += item.getCalorias();
        }
        return totalCalorias;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public void aceitar(br.com.hamburgueria.relatorio.ItemPedidoVisitor visitor) {
        visitor.visitar(this);
        for (ItemPedido item : itens) {
            item.aceitar(visitor);
        }
    }
}


