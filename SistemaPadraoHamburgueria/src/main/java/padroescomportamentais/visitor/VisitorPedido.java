package padroescomportamentais.visitor;

public interface VisitorPedido {

    float visitarHamburguer(Hamburguer hamburguer);

    float visitarBebida(Bebida bebida);
}
