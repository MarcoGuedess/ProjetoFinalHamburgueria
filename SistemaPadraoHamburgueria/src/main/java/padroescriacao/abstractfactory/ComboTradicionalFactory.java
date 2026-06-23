package padroescriacao.abstractfactory;

public class ComboTradicionalFactory implements ComboFactory {

    public Hamburguer criarHamburguer() {
        return new HamburguerTradicional();
    }

    public Bebida criarBebida() {
        return new Refrigerante();
    }
}
