package br.com.hamburgueria.relatorio.visitor;

import br.com.hamburgueria.cardapio.Acompanhamento;
import br.com.hamburgueria.cardapio.Bebida;
import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.composite.Combo;
import br.com.hamburgueria.cardapio.Lanche;
import br.com.hamburgueria.montagem.decorator.IngredienteAdicionalDecorator;


// Pattern 23: Visitor
public interface ItemPedidoVisitor {
    void visitar(Lanche lanche);
    void visitar(Bebida bebida);
    void visitar(Acompanhamento acompanhamento);
    void visitar(Combo combo);
    void visitar(IngredienteAdicionalDecorator decorator);
}


