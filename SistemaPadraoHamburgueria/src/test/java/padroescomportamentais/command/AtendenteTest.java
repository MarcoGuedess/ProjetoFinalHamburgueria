package padroescomportamentais.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtendenteTest {

    @Test
    void deveExecutarComandoPrepararPedido() {
        Pedido pedido = new Pedido();
        Atendente atendente = new Atendente();

        atendente.executarComando(new ComandoPrepararPedido(pedido));

        assertEquals("Em preparo", pedido.getStatus());
    }

    @Test
    void deveCancelarUltimoComando() {
        Pedido pedido = new Pedido();
        Atendente atendente = new Atendente();

        atendente.executarComando(new ComandoCancelarPedido(pedido));
        atendente.cancelarUltimoComando();

        assertEquals("Novo", pedido.getStatus());
    }
}
