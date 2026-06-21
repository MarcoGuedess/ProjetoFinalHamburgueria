package br.com.hamburgueria.pagamento.adapter;

import br.com.hamburgueria.dominio.Dinheiro;
import br.com.hamburgueria.pagamento.adapter.GatewayCartaoExterno;
import br.com.hamburgueria.pagamento.strategy.EstrategiaPagamento;


// Pattern 6: Adapter
public class GatewayPagamentoAdapter implements EstrategiaPagamento {
    private GatewayCartaoExterno gatewayExterno;
    private String numeroCartaoCliente;

    public GatewayPagamentoAdapter(String numeroCartaoCliente) {
        this.gatewayExterno = new GatewayCartaoExterno();
        this.numeroCartaoCliente = numeroCartaoCliente;
    }

    @Override
    public boolean processarPagamento(Dinheiro valor) {
        // Converte o tipo interno Dinheiro para o tipo primitivo exigido pela API Externa
        return gatewayExterno.cobrarCartao(numeroCartaoCliente, valor.getQuantia().doubleValue());
    }
}


