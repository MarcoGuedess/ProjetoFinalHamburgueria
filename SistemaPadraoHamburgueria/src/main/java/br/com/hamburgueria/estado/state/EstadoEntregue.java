package br.com.hamburgueria.estado.state;

import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.estado.state.PedidoState;


public class EstadoEntregue implements PedidoState {
    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi entregue.");
    }

    @Override
    public void pronto(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi entregue.");
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi entregue.");
    }

    @Override
    public String getNome() {
        return "Entregue";
    }
}


