package padroesestruturais.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import padroescriacao.builder.Pedido;
import padroescriacao.singleton.Estoque;

import static org.junit.jupiter.api.Assertions.*;

class AtendimentoHamburgueriaTest {

    @BeforeEach
    void setUp() {
        Estoque.getInstance().limpar();
        Estoque.getInstance().adicionarItem("pao", 3);
        Estoque.getInstance().adicionarItem("carne", 3);
    }

    @Test
    void deveRealizarPedidoCompleto() {
        AtendimentoHamburgueria atendimento = new AtendimentoHamburgueria();
        Pedido pedido = atendimento.realizarPedido(1, "Tiago", "Classico", 32.0f);

        assertEquals("Tiago", pedido.getCliente());
        assertEquals(2, Estoque.getInstance().getQuantidade("pao"));
        assertEquals(2, Estoque.getInstance().getQuantidade("carne"));
    }

    @Test
    void devePreencherDadosDoPedidoRealizado() {
        AtendimentoHamburgueria atendimento = new AtendimentoHamburgueria();
        Pedido pedido = atendimento.realizarPedido(2, "Ana", "X-Bacon", 40.0f);

        assertEquals(2, pedido.getNumero());
        assertEquals("Ana", pedido.getCliente());
        assertEquals("X-Bacon", pedido.getHamburguer());
        assertEquals(40.0f, pedido.getValor());
    }

    @Test
    void deveBaixarEstoqueAposMaisDeUmPedido() {
        AtendimentoHamburgueria atendimento = new AtendimentoHamburgueria();

        atendimento.realizarPedido(1, "Tiago", "Classico", 32.0f);
        atendimento.realizarPedido(2, "Ana", "X-Bacon", 40.0f);

        assertEquals(1, Estoque.getInstance().getQuantidade("pao"));
        assertEquals(1, Estoque.getInstance().getQuantidade("carne"));
    }

    @Test
    void naoDeveRealizarPedidoSemEstoque() {
        AtendimentoHamburgueria atendimento = new AtendimentoHamburgueria();
        Estoque.getInstance().baixarItem("pao", 3);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                atendimento.realizarPedido(1, "Tiago", "Classico", 32.0f)
        );

        assertEquals("Estoque insuficiente", exception.getMessage());
    }
}
