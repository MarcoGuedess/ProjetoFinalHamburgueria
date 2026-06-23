package padroescomportamentais.interpreter;

public class DescontoValor implements ExpressaoDesconto {

    private float desconto;

    public DescontoValor(float desconto) {
        this.desconto = desconto;
    }

    public float interpretar(float valor) {
        return valor - desconto;
    }
}
