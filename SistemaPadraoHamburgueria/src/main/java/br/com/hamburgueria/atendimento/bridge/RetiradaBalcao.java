package br.com.hamburgueria.atendimento.bridge;

import br.com.hamburgueria.atendimento.bridge.CanalEntrega;
import br.com.hamburgueria.dominio.Pedido;

public class RetiradaBalcao implements CanalEntrega {
    @Override
    public void enviarPedido(String detalhes) {
        System.out.println("Separando pedido para retirada no balcão: " + detalhes);
    }

    @Override
    public double getTaxaCanal() {
        return 0.0; // Sem taxa extra
    }
}


