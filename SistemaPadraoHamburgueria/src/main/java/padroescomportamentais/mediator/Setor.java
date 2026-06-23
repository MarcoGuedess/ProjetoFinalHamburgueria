package padroescomportamentais.mediator;

public abstract class Setor {

    protected CentralPedidos centralPedidos;
    protected String ultimaMensagem;

    public Setor(CentralPedidos centralPedidos) {
        this.centralPedidos = centralPedidos;
    }

    public abstract String getNome();

    public void enviar(String mensagem) {
        centralPedidos.enviar(mensagem, this);
    }

    public void receber(String mensagem) {
        ultimaMensagem = mensagem;
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
}
