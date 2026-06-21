package br.com.hamburgueria.estoque.flyweight;

import br.com.hamburgueria.estoque.flyweight.IngredienteFlyweight;

import java.util.HashMap;
import java.util.Map;

// Fabrica do Flyweight
public class FabricaIngredienteFlyweight {
    private static final Map<String, IngredienteFlyweight> flyweights = new HashMap<>();

    public static IngredienteFlyweight obterIngrediente(String nome, int calorias) {
        if (!flyweights.containsKey(nome)) {
            flyweights.put(nome, new IngredienteFlyweight(nome, calorias));
        }
        return flyweights.get(nome);
    }
}


