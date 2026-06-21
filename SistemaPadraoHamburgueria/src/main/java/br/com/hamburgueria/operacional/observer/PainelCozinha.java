package br.com.hamburgueria.operacional.observer;

import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.operacional.observer.Observer;


public class PainelCozinha implements Observer {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[COZINHA] Pedido atualizado! Status: " + pedido.getEstado().getNome());
    }
}


