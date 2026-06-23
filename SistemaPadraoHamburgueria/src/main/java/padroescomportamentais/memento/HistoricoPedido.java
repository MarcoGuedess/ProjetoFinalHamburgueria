package padroescomportamentais.memento;

import java.util.ArrayList;
import java.util.List;

public class HistoricoPedido {

    private List<PedidoMemento> historico = new ArrayList<PedidoMemento>();

    public void adicionar(PedidoMemento memento) {
        historico.add(memento);
    }

    public PedidoMemento getUltimo() {
        return historico.get(historico.size() - 1);
    }
}
