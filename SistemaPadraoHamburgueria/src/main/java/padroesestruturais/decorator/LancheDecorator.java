package padroesestruturais.decorator;

public abstract class LancheDecorator implements Lanche {

    private Lanche lanche;

    public LancheDecorator(Lanche lanche) {
        this.lanche = lanche;
    }

    public String getDescricao() {
        return lanche.getDescricao() + " + " + getNomeAdicional();
    }

    public float getPreco() {
        return lanche.getPreco() + getPrecoAdicional();
    }

    public abstract String getNomeAdicional();

    public abstract float getPrecoAdicional();
}
