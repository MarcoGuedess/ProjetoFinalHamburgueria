package padroescomportamentais.iterator;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class FilaPedidosTest {

    @Test
    void deveContarPedidosProntos() {
        FilaPedidos fila = new FilaPedidos();
        fila.adicionarPedido(new Pedido("Ana", true));
        fila.adicionarPedido(new Pedido("Bruno", false));
        fila.adicionarPedido(new Pedido("Carla", true));

        assertEquals(2, fila.contarPedidosProntos());
    }

    @Test
    void deveContarZeroPedidosProntosQuandoFilaNaoTemProntos() {
        FilaPedidos fila = new FilaPedidos();
        fila.adicionarPedido(new Pedido("Ana", false));
        fila.adicionarPedido(new Pedido("Bruno", false));

        assertEquals(0, fila.contarPedidosProntos());
    }

    @Test
    void devePercorrerPedidosNaOrdemDeEntrada() {
        FilaPedidos fila = new FilaPedidos();
        fila.adicionarPedido(new Pedido("Ana", true));
        fila.adicionarPedido(new Pedido("Bruno", false));

        Iterator<Pedido> iterator = fila.iterator();

        assertEquals("Ana", iterator.next().getCliente());
        assertEquals("Bruno", iterator.next().getCliente());
        assertFalse(iterator.hasNext());
    }
}
