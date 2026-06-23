package padroescomportamentais.command;

public class Pedido {

    private String status;

    public Pedido() {
        this.status = "Novo";
    }

    public void preparar() {
        this.status = "Em preparo";
    }

    public void voltarParaNovo() {
        this.status = "Novo";
    }

    public void cancelar() {
        this.status = "Cancelado";
    }

    public String getStatus() {
        return status;
    }
}
