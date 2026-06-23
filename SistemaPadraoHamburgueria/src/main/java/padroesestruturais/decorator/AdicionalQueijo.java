package padroesestruturais.decorator;

public class AdicionalQueijo extends LancheDecorator {

    public AdicionalQueijo(Lanche lanche) {
        super(lanche);
    }

    public String getNomeAdicional() {
        return "queijo";
    }

    public float getPrecoAdicional() {
        return 3.0f;
    }
}
