package padroescomportamentais.state;

public class PedidoEstadoSaiuParaEntrega extends PedidoEstado {

    private PedidoEstadoSaiuParaEntrega() {}
    private static PedidoEstadoSaiuParaEntrega instance = new PedidoEstadoSaiuParaEntrega();

    public static PedidoEstadoSaiuParaEntrega getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Saiu para entrega";
    }

    public boolean finalizar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoFinalizado.getInstance());
        return true;
    }
}
