package br.com.hamburgueria.montagem.decorator;

import br.com.hamburgueria.dominio.Dinheiro;
import br.com.hamburgueria.dominio.ItemPedido;
import br.com.hamburgueria.estoque.flyweight.IngredienteFlyweight;
import br.com.hamburgueria.relatorio.visitor.ItemPedidoVisitor;


// Pattern 9: Decorator
public abstract class IngredienteAdicionalDecorator implements ItemPedido {
    protected ItemPedido lancheBase;
    protected IngredienteFlyweight ingredienteFisico;
    protected Dinheiro precoAdicional;

    public IngredienteAdicionalDecorator(ItemPedido lancheBase, IngredienteFlyweight ingrediente, Dinheiro precoAdicional) {
        this.lancheBase = lancheBase;
        this.ingredienteFisico = ingrediente;
        this.precoAdicional = precoAdicional;
    }

    @Override
    public String getNome() {
        return lancheBase.getNome() + " + " + ingredienteFisico.getNome();
    }

    @Override
    public Dinheiro getPreco() {
        return lancheBase.getPreco().somar(precoAdicional);
    }

    @Override
    public int getCalorias() {
        return lancheBase.getCalorias() + ingredienteFisico.getCaloriasAdicionais();
    }

    @Override
    public void aceitar(br.com.hamburgueria.relatorio.ItemPedidoVisitor visitor) {
        visitor.visitar(this);
        lancheBase.aceitar(visitor);
    }
}


