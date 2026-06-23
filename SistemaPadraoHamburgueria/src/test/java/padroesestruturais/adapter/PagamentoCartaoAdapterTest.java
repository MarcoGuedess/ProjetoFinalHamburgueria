package padroesestruturais.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoCartaoAdapterTest {

    @Test
    void deveAdaptarPagamentoParaCentavos() {
        GatewayPagamento pagamento = new PagamentoCartaoAdapter(new MaquinaCartaoExterna());
        assertEquals("Pagamento autorizado: 3200.0", pagamento.pagar(32.0f));
    }

    @Test
    void deveAdaptarPagamentoComCentavosNoValor() {
        GatewayPagamento pagamento = new PagamentoCartaoAdapter(new MaquinaCartaoExterna());
        assertEquals("Pagamento autorizado: 4599.0", pagamento.pagar(45.99f));
    }

    @Test
    void deveAdaptarPagamentoZerado() {
        GatewayPagamento pagamento = new PagamentoCartaoAdapter(new MaquinaCartaoExterna());
        assertEquals("Pagamento autorizado: 0.0", pagamento.pagar(0.0f));
    }
}
