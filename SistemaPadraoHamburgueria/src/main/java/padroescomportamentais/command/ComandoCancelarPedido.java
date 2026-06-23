package padroescomportamentais.command;

public class ComandoCancelarPedido implements Comando {

    private Pedido pedido;

    public ComandoCancelarPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void executar() {
        pedido.cancelar();
    }

    public void cancelar() {
        pedido.voltarParaNovo();
    }
}
