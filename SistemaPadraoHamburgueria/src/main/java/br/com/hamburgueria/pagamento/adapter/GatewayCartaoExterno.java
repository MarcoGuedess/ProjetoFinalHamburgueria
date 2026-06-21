package br.com.hamburgueria.pagamento.adapter;

public class GatewayCartaoExterno {
    public boolean cobrarCartao(String numCartao, double valorCobrado) {
        // Simula chamada de rede demorada para Cielo/Rede
        System.out.println("[GATEWAY EXTERNO] Cobrando " + valorCobrado + " no cartão " + numCartao);
        return true;
    }
}

