package padroescomportamentais.strategy;

public class CalculadoraEntrega {

    private float valorBase;

    public CalculadoraEntrega(float valorBase) {
        this.valorBase = valorBase;
    }

    public float calcular(Frete frete) {
        return frete.calcular(valorBase);
    }
}
