package padroesestruturais.adapter;

public class PagamentoCartaoAdapter implements GatewayPagamento {

    private MaquinaCartaoExterna maquinaCartao;

    public PagamentoCartaoAdapter(MaquinaCartaoExterna maquinaCartao) {
        this.maquinaCartao = maquinaCartao;
    }

    public String pagar(float valor) {
        return maquinaCartao.autorizar(valor * 100.0f);
    }
}
