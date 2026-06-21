package br.com.hamburgueria.dominio;

import br.com.hamburgueria.dominio.Dinheiro;
import br.com.hamburgueria.relatorio.visitor.ItemPedidoVisitor;


public interface ItemPedido {
    String getNome();
    Dinheiro getPreco();
    int getCalorias();
    void aceitar(ItemPedidoVisitor visitor);
}

