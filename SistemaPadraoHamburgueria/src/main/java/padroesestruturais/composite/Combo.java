package padroesestruturais.composite;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemPedido {

    private String descricao;
    private List<ItemPedido> itens = new ArrayList<ItemPedido>();

    public Combo(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        float total = 0.0f;
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }
        return total;
    }
}
