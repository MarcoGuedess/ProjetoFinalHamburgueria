package padroescomportamentais.memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoMementoTest {

    @Test
    void deveRestaurarStatusAnterior() {
        Pedido pedido = new Pedido();
        HistoricoPedido historico = new HistoricoPedido();

        historico.adicionar(pedido.salvar());
        pedido.setStatus("Cancelado");
        pedido.restaurar(historico.getUltimo());

        assertEquals("Recebido", pedido.getStatus());
    }

    @Test
    void deveRestaurarUltimoStatusSalvo() {
        Pedido pedido = new Pedido();
        HistoricoPedido historico = new HistoricoPedido();

        pedido.setStatus("Em preparo");
        historico.adicionar(pedido.salvar());
        pedido.setStatus("Saiu para entrega");
        historico.adicionar(pedido.salvar());
        pedido.setStatus("Cancelado");
        pedido.restaurar(historico.getUltimo());

        assertEquals("Saiu para entrega", pedido.getStatus());
    }

    @Test
    void deveManterStatusSalvoNoMementoMesmoDepoisDaMudancaDoPedido() {
        Pedido pedido = new Pedido();
        pedido.setStatus("Em preparo");

        PedidoMemento memento = pedido.salvar();
        pedido.setStatus("Finalizado");

        assertEquals("Em preparo", memento.getStatus());
        assertEquals("Finalizado", pedido.getStatus());
    }
}
