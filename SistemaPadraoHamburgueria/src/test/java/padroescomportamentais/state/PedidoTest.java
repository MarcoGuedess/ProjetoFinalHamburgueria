package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
    }

    @Test
    void devePrepararPedidoRecebido() {
        pedido.setEstado(PedidoEstadoRecebido.getInstance());
        assertTrue(pedido.preparar());
        assertEquals(PedidoEstadoEmPreparo.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveFinalizarPedidoRecebido() {
        pedido.setEstado(PedidoEstadoRecebido.getInstance());
        assertFalse(pedido.finalizar());
    }

    @Test
    void deveCancelarPedidoRecebido() {
        pedido.setEstado(PedidoEstadoRecebido.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveEnviarPedidoRecebidoParaEntrega() {
        pedido.setEstado(PedidoEstadoRecebido.getInstance());
        assertFalse(pedido.sairParaEntrega());
    }

    @Test
    void deveEnviarPedidoEmPreparoParaEntrega() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertTrue(pedido.sairParaEntrega());
        assertEquals(PedidoEstadoSaiuParaEntrega.getInstance(), pedido.getEstado());
    }

    @Test
    void deveCancelarPedidoEmPreparo() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDevePrepararPedidoEmPreparoNovamente() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveFinalizarPedidoEmPreparo() {
        pedido.setEstado(PedidoEstadoEmPreparo.getInstance());
        assertFalse(pedido.finalizar());
    }

    @Test
    void deveFinalizarPedidoQueSaiuParaEntrega() {
        pedido.setEstado(PedidoEstadoSaiuParaEntrega.getInstance());
        assertTrue(pedido.finalizar());
        assertEquals(PedidoEstadoFinalizado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDevePrepararPedidoQueSaiuParaEntrega() {
        pedido.setEstado(PedidoEstadoSaiuParaEntrega.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveCancelarPedidoQueSaiuParaEntrega() {
        pedido.setEstado(PedidoEstadoSaiuParaEntrega.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    void naoDeveCancelarPedidoFinalizado() {
        pedido.setEstado(PedidoEstadoFinalizado.getInstance());
        assertFalse(pedido.cancelar());
    }

    @Test
    void naoDevePrepararPedidoFinalizado() {
        pedido.setEstado(PedidoEstadoFinalizado.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveFinalizarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.finalizar());
    }

    @Test
    void deveRetornarNomeDoEstadoAtual() {
        pedido.setEstado(PedidoEstadoSaiuParaEntrega.getInstance());
        assertEquals("Saiu para entrega", pedido.getNomeEstado());
    }
}
