package padroescomportamentais.strategy;

public class FreteMotoboy implements Frete {

    public float calcular(float distancia) {
        if (distancia <= 0.0f) {
            throw new IllegalArgumentException("Distancia invalida");
        }
        return 5.0f + (distancia * 2.0f);
    }
}
