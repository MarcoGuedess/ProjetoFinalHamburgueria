package padroesestruturais.bridge;

public class LancheFrango extends Lanche {

    public LancheFrango(FormaPreparo formaPreparo) {
        super(formaPreparo);
    }

    public String montar() {
        return "Lanche de frango " + formaPreparo.preparar();
    }
}
