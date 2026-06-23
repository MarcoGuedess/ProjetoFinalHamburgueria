package padroescomportamentais.visitor;

public class Hamburguer implements ItemPedido {

    private float preco;

    public Hamburguer(float preco) {
        this.preco = preco;
    }

    public float aceitar(VisitorPedido visitor) {
        return visitor.visitarHamburguer(this);
    }

    public float getPreco() {
        return preco;
    }
}
