package padroescomportamentais.chainofresponsibility;

public class Pedido {

    private String cliente;
    private String hamburguer;
    private boolean pago;
    private boolean pronto;

    public Pedido(String cliente, String hamburguer) {
        this.cliente = cliente;
        this.hamburguer = hamburguer;
    }

    public String getCliente() {
        return cliente;
    }

    public String getHamburguer() {
        return hamburguer;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isPronto() {
        return pronto;
    }

    public void setPronto(boolean pronto) {
        this.pronto = pronto;
    }
}
