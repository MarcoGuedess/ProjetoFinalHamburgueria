package br.com.hamburgueria.pagamento.strategy;

import br.com.hamburgueria.dominio.Dinheiro;


// Pattern 21: Strategy
public interface EstrategiaPagamento {
    boolean processarPagamento(Dinheiro valor);
}


