package br.com.hamburgueria.estado.state;

import br.com.hamburgueria.dominio.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PedidoStateTest {

    @Test
    public void devePassarParaProximoEstadoComSucesso() {
        Pedido pedido = new Pedido();
        assertEquals("Novo", pedido.getEstado().getNome());
        
        pedido.getEstado().preparar(pedido);
        assertEquals("Em Preparo", pedido.getEstado().getNome());
        
        pedido.getEstado().pronto(pedido);
        assertEquals("Pronto", pedido.getEstado().getNome());
        
        pedido.getEstado().entregar(pedido);
        assertEquals("Entregue", pedido.getEstado().getNome());
    }

    @Test
    public void deveLancarExcecaoAoPularEstado() {
        Pedido pedido = new Pedido();
        
        // Tentar pular de Novo direto para Pronto
        assertThrows(IllegalStateException.class, () -> {
            pedido.getEstado().pronto(pedido);
        });
    }
}
