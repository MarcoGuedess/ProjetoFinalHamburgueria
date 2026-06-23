package padroesestruturais.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioVendasProxyTest {

    @Test
    void deveEmitirRelatorioParaGerente() {
        Relatorio relatorio = new RelatorioVendasProxy();
        assertEquals("Relatorio de vendas emitido", relatorio.emitir("gerente"));
    }

    @Test
    void deveBloquearRelatorioParaAtendente() {
        try {
            Relatorio relatorio = new RelatorioVendasProxy();
            relatorio.emitir("atendente");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Acesso negado", e.getMessage());
        }
    }
}
