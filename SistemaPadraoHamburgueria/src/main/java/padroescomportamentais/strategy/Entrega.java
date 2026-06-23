package padroescomportamentais.strategy;

public class Entrega {

    private float valor;

    public float getValor() {
        return valor;
    }

    public void calcularRetirada() {
        CalculadoraEntrega calculadora = new CalculadoraEntrega(0.0f);
        this.valor = calculadora.calcular(new FreteRetirada());
    }

    public void calcularBairroProximo() {
        CalculadoraEntrega calculadora = new CalculadoraEntrega(6.0f);
        this.valor = calculadora.calcular(new FreteBairro());
    }

    public void calcularMotoboy(float distancia) {
        CalculadoraEntrega calculadora = new CalculadoraEntrega(distancia);
        this.valor = calculadora.calcular(new FreteMotoboy());
    }
}
