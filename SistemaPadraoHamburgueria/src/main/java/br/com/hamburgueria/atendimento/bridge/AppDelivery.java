package br.com.hamburgueria.atendimento.bridge;

import br.com.hamburgueria.atendimento.bridge.CanalEntrega;
import br.com.hamburgueria.dominio.Pedido;

public class AppDelivery implements CanalEntrega {
    @Override
    public void enviarPedido(String detalhes) {
        System.out.println("Enviando pedido via IFood/AppDelivery: " + detalhes);
    }

    @Override
    public double getTaxaCanal() {
        return 0.10; // 10% de taxa do app
    }
}


