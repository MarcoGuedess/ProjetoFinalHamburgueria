package br.com.hamburgueria.estado.state;

import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.estado.state.EstadoPronto;
import br.com.hamburgueria.estado.state.PedidoState;


public class EstadoEmPreparo implements PedidoState {
    @Override
    public void preparar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está em preparo.");
    }

    @Override
    public void pronto(Pedido pedido) {
        pedido.setEstado(new EstadoPronto());
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido Em Preparo não pode ser entregue.");
    }

    @Override
    public String getNome() {
        return "Em Preparo";
    }
}


