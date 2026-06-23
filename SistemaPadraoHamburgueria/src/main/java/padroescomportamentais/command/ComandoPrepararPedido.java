package padroescomportamentais.command;

public class ComandoPrepararPedido implements Comando {

    private Pedido pedido;

    public ComandoPrepararPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void executar() {
        pedido.preparar();
    }

    public void cancelar() {
        pedido.voltarParaNovo();
    }
}
