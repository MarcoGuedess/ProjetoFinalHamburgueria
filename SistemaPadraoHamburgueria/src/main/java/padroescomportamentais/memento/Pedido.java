package padroescomportamentais.memento;

public class Pedido {

    private String status;

    public Pedido() {
        this.status = "Recebido";
    }

    public PedidoMemento salvar() {
        return new PedidoMemento(status);
    }

    public void restaurar(PedidoMemento memento) {
        this.status = memento.getStatus();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
