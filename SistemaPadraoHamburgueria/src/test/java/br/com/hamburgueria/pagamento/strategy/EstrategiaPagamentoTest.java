package br.com.hamburgueria.pagamento.strategy;

import br.com.hamburgueria.dominio.Dinheiro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstrategiaPagamentoTest {

    @Test
    public void deveProcessarPagamentoComPix() {
        EstrategiaPagamento pagamentoPix = new PagamentoPix();
        boolean aprovado = pagamentoPix.processarPagamento(Dinheiro.reais(50.0));
        assertTrue(aprovado);
    }
}
