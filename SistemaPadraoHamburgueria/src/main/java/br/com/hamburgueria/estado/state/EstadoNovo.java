package br.com.hamburgueria.estado.state;

import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.estado.state.EstadoEmPreparo;
import br.com.hamburgueria.estado.state.PedidoState;


public class EstadoNovo implements PedidoState {
    @Override
    public void preparar(Pedido pedido) {
        pedido.setEstado(new EstadoEmPreparo());
    }

    @Override
    public void pronto(Pedido pedido) {
        throw new IllegalStateException("Pedido Novo não pode ir direto para Pronto.");
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido Novo não pode ser entregue.");
    }

    @Override
    public String getNome() {
        return "Novo";
    }
}


