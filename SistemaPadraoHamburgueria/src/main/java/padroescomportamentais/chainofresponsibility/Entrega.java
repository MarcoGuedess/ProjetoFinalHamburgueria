package padroescomportamentais.chainofresponsibility;

public class Entrega extends Handler {

    public String processar(Pedido pedido) {
        if (!pedido.isPronto()) {
            return "Pedido ainda nao esta pronto para entrega";
        }
        return "Entrega saiu com pedido de " + pedido.getCliente();
    }
}
