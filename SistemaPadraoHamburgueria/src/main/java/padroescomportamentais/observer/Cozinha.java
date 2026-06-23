package padroescomportamentais.observer;

public class Cozinha implements Setor {

    private String ultimaNotificacao;

    public void atualizar(PedidoMonitorado pedido) {
        ultimaNotificacao = "Cozinha recebeu status: " + pedido.getStatus();
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}
