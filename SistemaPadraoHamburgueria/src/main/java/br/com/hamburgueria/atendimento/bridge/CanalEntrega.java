package br.com.hamburgueria.atendimento.bridge;

// Pattern 7: Bridge (Implementor)
public interface CanalEntrega {
    void enviarPedido(String detalhes);
    double getTaxaCanal();
}

