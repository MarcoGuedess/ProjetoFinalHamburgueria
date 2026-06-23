package padroesestruturais.flyweight;

import java.util.HashMap;
import java.util.Map;

public class IngredienteFactory {

    private static Map<String, Ingrediente> ingredientes = new HashMap<String, Ingrediente>();

    public static Ingrediente getIngrediente(String nome) {
        Ingrediente ingrediente = ingredientes.get(nome);
        if (ingrediente == null) {
            ingrediente = new Ingrediente(nome);
            ingredientes.put(nome, ingrediente);
        }
        return ingrediente;
    }

    public static int getQuantidadeIngredientes() {
        return ingredientes.size();
    }

    public static void limpar() {
        ingredientes.clear();
    }
}
