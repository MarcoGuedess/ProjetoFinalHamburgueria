package br.com.hamburgueria.montagem.decorator;

import br.com.hamburgueria.dominio.Dinheiro;
import br.com.hamburgueria.dominio.ItemPedido;
import br.com.hamburgueria.estoque.flyweight.FabricaIngredienteFlyweight;
import br.com.hamburgueria.montagem.decorator.IngredienteAdicionalDecorator;


public class AdicionalBacon extends IngredienteAdicionalDecorator {
    public AdicionalBacon(ItemPedido lancheBase) {
        super(lancheBase, 
              FabricaIngredienteFlyweight.obterIngrediente("Bacon Extra", 100), 
              Dinheiro.reais(5.00));
    }
}


