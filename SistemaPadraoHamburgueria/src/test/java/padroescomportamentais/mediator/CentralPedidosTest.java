package padroescomportamentais.mediator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CentralPedidosTest {

    @Test
    void deveMediarComunicacaoEntreSetores() {
        CentralPedidos central = new CentralPedidos();
        Atendimento atendimento = new Atendimento(central);
        Cozinha cozinha = new Cozinha(central);

        central.adicionarSetor(atendimento);
        central.adicionarSetor(cozinha);
        atendimento.enviar("Pedido 10 recebido");

        assertEquals("Atendimento: Pedido 10 recebido", cozinha.getUltimaMensagem());
    }

    @Test
    void deveMediarComunicacaoDaCozinhaParaAtendimento() {
        CentralPedidos central = new CentralPedidos();
        Atendimento atendimento = new Atendimento(central);
        Cozinha cozinha = new Cozinha(central);

        central.adicionarSetor(atendimento);
        central.adicionarSetor(cozinha);
        cozinha.enviar("Pedido 10 pronto");

        assertEquals("Cozinha: Pedido 10 pronto", atendimento.getUltimaMensagem());
    }

    @Test
    void naoDeveEnviarMensagemParaOProprioRemetente() {
        CentralPedidos central = new CentralPedidos();
        Atendimento atendimento = new Atendimento(central);
        Cozinha cozinha = new Cozinha(central);

        central.adicionarSetor(atendimento);
        central.adicionarSetor(cozinha);
        atendimento.enviar("Pedido 10 recebido");

        assertNull(atendimento.getUltimaMensagem());
    }
}
