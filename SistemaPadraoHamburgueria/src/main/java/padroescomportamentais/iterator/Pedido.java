package padroescomportamentais.iterator;

public class Pedido {

    private String cliente;
    private boolean pronto;

    public Pedido(String cliente, boolean pronto) {
        this.cliente = cliente;
        this.pronto = pronto;
    }

    public String getCliente() {
        return cliente;
    }

    public boolean isPronto() {
        return pronto;
    }
}
