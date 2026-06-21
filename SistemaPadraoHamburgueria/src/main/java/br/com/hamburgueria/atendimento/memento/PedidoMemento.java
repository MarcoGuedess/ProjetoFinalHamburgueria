package br.com.hamburgueria.atendimento.memento;

import br.com.hamburgueria.dominio.ItemPedido;

import java.util.ArrayList;
import java.util.List;

// Pattern 18: Memento
public class PedidoMemento {
    private final List<ItemPedido> itensSalvos;

    public PedidoMemento(List<ItemPedido> itensParaSalvar) {
        this.itensSalvos = new ArrayList<>(itensParaSalvar);
    }

    public List<ItemPedido> getItensSalvos() {
        return new ArrayList<>(itensSalvos); // Retorna cópia para não ferir o encapsulamento
    }
}


