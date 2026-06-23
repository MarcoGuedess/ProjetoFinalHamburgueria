package padroescriacao.abstractfactory;

public class Combo {

    private Hamburguer hamburguer;
    private Bebida bebida;

    public Combo(ComboFactory factory) {
        this.hamburguer = factory.criarHamburguer();
        this.bebida = factory.criarBebida();
    }

    public String getDescricao() {
        return hamburguer.getDescricao() + " com " + bebida.getDescricao();
    }
}
