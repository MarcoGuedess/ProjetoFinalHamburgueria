package br.com.hamburgueria.pagamento.strategy;

import br.com.hamburgueria.dominio.Dinheiro;
import br.com.hamburgueria.pagamento.strategy.EstrategiaPagamento;


public class PagamentoPix implements EstrategiaPagamento {
    @Override
    public boolean processarPagamento(Dinheiro valor) {
        System.out.println("Processando PIX no valor de " + valor.toString());
        // Simula aprovação imediata
        return true;
    }
}


