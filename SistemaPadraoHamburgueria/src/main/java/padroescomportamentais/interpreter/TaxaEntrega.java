package padroescomportamentais.interpreter;

public class TaxaEntrega implements ExpressaoDesconto {

    private float taxa;

    public TaxaEntrega(float taxa) {
        this.taxa = taxa;
    }

    public float interpretar(float valor) {
        return valor + taxa;
    }
}
