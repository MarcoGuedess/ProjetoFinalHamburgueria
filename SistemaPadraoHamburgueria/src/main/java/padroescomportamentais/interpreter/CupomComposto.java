package padroescomportamentais.interpreter;

public class CupomComposto implements ExpressaoDesconto {

    private ExpressaoDesconto primeiraExpressao;
    private ExpressaoDesconto segundaExpressao;

    public CupomComposto(ExpressaoDesconto primeiraExpressao, ExpressaoDesconto segundaExpressao) {
        this.primeiraExpressao = primeiraExpressao;
        this.segundaExpressao = segundaExpressao;
    }

    public float interpretar(float valor) {
        return segundaExpressao.interpretar(primeiraExpressao.interpretar(valor));
    }
}
