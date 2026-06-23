package padroescomportamentais.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilaPedidos implements Iterable<Pedido> {

    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Iterator<Pedido> iterator() {
        return pedidos.iterator();
    }

    public int contarPedidosProntos() {
        int quantidade = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.isPronto()) {
                quantidade++;
            }
        }
        return quantidade;
    }
}
