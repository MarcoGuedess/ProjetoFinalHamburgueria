package padroesestruturais.decorator;

public class AdicionalBacon extends LancheDecorator {

    public AdicionalBacon(Lanche lanche) {
        super(lanche);
    }

    public String getNomeAdicional() {
        return "bacon";
    }

    public float getPrecoAdicional() {
        return 5.0f;
    }
}
