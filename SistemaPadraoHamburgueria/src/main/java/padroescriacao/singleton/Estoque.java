package padroescriacao.singleton;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    private Estoque() {}

    private static Estoque instance = new Estoque();
    private Map<String, Integer> itens = new HashMap<String, Integer>();

    public static Estoque getInstance() {
        return instance;
    }

    public void limpar() {
        itens.clear();
    }

    public void adicionarItem(String nome, int quantidade) {
        itens.put(nome, getQuantidade(nome) + quantidade);
    }

    public void baixarItem(String nome, int quantidade) {
        if (getQuantidade(nome) < quantidade) {
            throw new IllegalArgumentException("Estoque insuficiente");
        }
        itens.put(nome, getQuantidade(nome) - quantidade);
    }

    public int getQuantidade(String nome) {
        return itens.getOrDefault(nome, 0);
    }
}
