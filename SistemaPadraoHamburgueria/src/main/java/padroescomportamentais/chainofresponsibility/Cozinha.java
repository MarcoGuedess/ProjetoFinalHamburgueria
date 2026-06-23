package padroescomportamentais.chainofresponsibility;

public class Cozinha extends Handler {

    public String processar(Pedido pedido) {
        pedido.setPronto(true);
        if (proximo != null) {
            return "Cozinha preparou " + pedido.getHamburguer() + " -> " + proximo.processar(pedido);
        }
        return "Cozinha preparou " + pedido.getHamburguer();
    }
}
