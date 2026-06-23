package padroesestruturais.bridge;

public abstract class Lanche {

    protected FormaPreparo formaPreparo;

    public Lanche(FormaPreparo formaPreparo) {
        this.formaPreparo = formaPreparo;
    }

    public abstract String montar();
}
