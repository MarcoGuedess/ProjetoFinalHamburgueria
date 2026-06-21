package br.com.hamburgueria.operacional.observer;

import br.com.hamburgueria.dominio.Cliente;
import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.operacional.observer.Observer;


public class AppCliente implements Observer {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("[APP CLIENTE] Olá " + pedido.getCliente().getNome() + 
                           ", o status do seu pedido mudou para: " + pedido.getEstado().getNome());
    }
}


