package padroesestruturais.composite;

public class Produto implements ItemPedido {

    private String descricao;
    private float preco;

    public Produto(String descricao, float preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        return preco;
    }
}
