package br.com.hamburgueria.montagem.builder;

import br.com.hamburgueria.cardapio.LancheTradicional;
import br.com.hamburgueria.dominio.Cliente;
import br.com.hamburgueria.dominio.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoBuilderTest {

    @Test
    public void deveConstruirPedidoComSucessoQuandoTiverClienteEItens() {
        PedidoBuilder builder = new PedidoBuilder();
        
        Pedido pedido = builder
                .comCliente(new Cliente("Maria", "Rua A"))
                .adicionarItem(new LancheTradicional())
                .construir();
                
        assertNotNull(pedido);
        assertEquals("Maria", pedido.getCliente().getNome());
        assertEquals(1, pedido.getItens().size());
    }

    @Test
    public void deveLancarExcecaoAoConstruirPedidoVazio() {
        PedidoBuilder builder = new PedidoBuilder();
        builder.comCliente(new Cliente("João", "Rua B"));
        
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            builder.construir();
        });
        
        assertEquals("O pedido deve ter pelo menos um item.", exception.getMessage());
    }
}
