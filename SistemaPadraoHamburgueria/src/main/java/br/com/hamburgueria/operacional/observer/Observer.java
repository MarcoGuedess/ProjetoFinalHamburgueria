package br.com.hamburgueria.operacional.observer;

import br.com.hamburgueria.dominio.Pedido;


// Pattern 19: Observer
public interface Observer {
    void atualizar(Pedido pedido);
}


