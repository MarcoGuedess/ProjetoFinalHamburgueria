package padroescomportamentais.chainofresponsibility;

public abstract class Handler {

    protected Handler proximo;

    public void setProximo(Handler proximo) {
        this.proximo = proximo;
    }

    public abstract String processar(Pedido pedido);
}
