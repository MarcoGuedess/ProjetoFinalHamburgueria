package br.com.hamburgueria.estado.state;

import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.estado.state.EstadoEntregue;
import br.com.hamburgueria.estado.state.PedidoState;


public class EstadoPronto implements PedidoState {
    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está pronto.");
    }

    @Override
    public void pronto(Pedido pedido) {
        throw new IllegalStateException("Pedido já está pronto.");
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.setEstado(new EstadoEntregue());
    }

    @Override
    public String getNome() {
        return "Pronto";
    }
}


