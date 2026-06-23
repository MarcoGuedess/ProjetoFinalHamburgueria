package padroescriacao.abstractfactory;

public class ComboVeganoFactory implements ComboFactory {

    public Hamburguer criarHamburguer() {
        return new HamburguerVegano();
    }

    public Bebida criarBebida() {
        return new SucoNatural();
    }
}
