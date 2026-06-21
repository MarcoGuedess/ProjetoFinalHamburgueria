package br.com.hamburgueria.estado.state;

import br.com.hamburgueria.dominio.Pedido;


// Pattern 20: State
public interface PedidoState {
    void preparar(Pedido pedido);
    void pronto(Pedido pedido);
    void entregar(Pedido pedido);
    String getNome();
}


