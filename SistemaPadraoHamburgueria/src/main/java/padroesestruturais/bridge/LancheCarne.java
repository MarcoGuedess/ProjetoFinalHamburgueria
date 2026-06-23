package padroesestruturais.bridge;

public class LancheCarne extends Lanche {

    public LancheCarne(FormaPreparo formaPreparo) {
        super(formaPreparo);
    }

    public String montar() {
        return "Lanche de carne " + formaPreparo.preparar();
    }
}
