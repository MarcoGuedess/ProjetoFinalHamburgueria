package br.com.hamburgueria.montagem.builder;

import br.com.hamburgueria.dominio.Cliente;
import br.com.hamburgueria.dominio.ItemPedido;
import br.com.hamburgueria.dominio.Pedido;


// Pattern 4: Builder
public class PedidoBuilder {
    private Pedido pedido;

    public PedidoBuilder() {
        this.pedido = new Pedido();
    }

    public PedidoBuilder comCliente(Cliente cliente) {
        this.pedido.setCliente(cliente);
        return this;
    }

    public PedidoBuilder adicionarItem(ItemPedido item) {
        this.pedido.adicionarItem(item);
        return this;
    }

    public Pedido construir() {
        if (this.pedido.getItens().isEmpty()) {
            throw new IllegalStateException("O pedido deve ter pelo menos um item.");
        }
        return this.pedido;
    }
}


