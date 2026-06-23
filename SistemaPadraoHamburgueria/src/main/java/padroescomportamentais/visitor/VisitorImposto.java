package padroescomportamentais.visitor;

public class VisitorImposto implements VisitorPedido {

    public float visitarHamburguer(Hamburguer hamburguer) {
        return hamburguer.getPreco() * 0.10f;
    }

    public float visitarBebida(Bebida bebida) {
        return bebida.getPreco() * 0.05f;
    }
}
