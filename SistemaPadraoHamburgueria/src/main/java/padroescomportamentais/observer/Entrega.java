package padroescomportamentais.observer;

public class Entrega implements Setor {

    private String ultimaNotificacao;

    public void atualizar(PedidoMonitorado pedido) {
        ultimaNotificacao = "Entrega recebeu status: " + pedido.getStatus();
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}
