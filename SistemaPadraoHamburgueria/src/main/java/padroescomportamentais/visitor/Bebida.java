package padroescomportamentais.visitor;

public class Bebida implements ItemPedido {

    private float preco;

    public Bebida(float preco) {
        this.preco = preco;
    }

    public float aceitar(VisitorPedido visitor) {
        return visitor.visitarBebida(this);
    }

    public float getPreco() {
        return preco;
    }
}
