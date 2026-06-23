package padroescomportamentais.chainofresponsibility;

public class Atendimento extends Handler {

    public String processar(Pedido pedido) {
        if (!pedido.isPago()) {
            return "Pedido aguardando pagamento";
        }
        if (proximo != null) {
            return "Atendimento registrou pedido de " + pedido.getCliente() + " -> " + proximo.processar(pedido);
        }
        return "Atendimento registrou pedido";
    }
}
