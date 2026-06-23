package padroescomportamentais.state;

public class PedidoEstadoFinalizado extends PedidoEstado {

    private PedidoEstadoFinalizado() {}
    private static PedidoEstadoFinalizado instance = new PedidoEstadoFinalizado();

    public static PedidoEstadoFinalizado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Finalizado";
    }
}
