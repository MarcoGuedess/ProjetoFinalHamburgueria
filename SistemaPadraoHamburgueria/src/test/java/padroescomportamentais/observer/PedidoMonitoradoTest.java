package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoMonitoradoTest {

    @Test
    void deveNotificarSetoresQuandoStatusMudar() {
        PedidoMonitorado pedido = new PedidoMonitorado();
        Cozinha cozinha = new Cozinha();
        Entrega entrega = new Entrega();

        pedido.adicionarSetor(cozinha);
        pedido.adicionarSetor(entrega);
        pedido.setStatus("Em preparo");

        assertEquals("Cozinha recebeu status: Em preparo", cozinha.getUltimaNotificacao());
        assertEquals("Entrega recebeu status: Em preparo", entrega.getUltimaNotificacao());
    }

    @Test
    void deveAtualizarNotificacaoQuandoStatusMudarNovamente() {
        PedidoMonitorado pedido = new PedidoMonitorado();
        Cozinha cozinha = new Cozinha();

        pedido.adicionarSetor(cozinha);
        pedido.setStatus("Em preparo");
        pedido.setStatus("Finalizado");

        assertEquals("Cozinha recebeu status: Finalizado", cozinha.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarSetorNaoCadastrado() {
        PedidoMonitorado pedido = new PedidoMonitorado();
        Cozinha cozinha = new Cozinha();

        pedido.setStatus("Em preparo");

        assertNull(cozinha.getUltimaNotificacao());
    }
}
