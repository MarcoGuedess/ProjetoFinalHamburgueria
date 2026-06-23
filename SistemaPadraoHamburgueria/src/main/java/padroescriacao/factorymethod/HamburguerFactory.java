package padroescriacao.factorymethod;

public class HamburguerFactory {

    public static Hamburguer obterHamburguer(String tipo) {
        Class<?> classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("padroescriacao.factorymethod.Hamburguer" + tipo);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Hamburguer inexistente");
        }
        if (!(objeto instanceof Hamburguer)) {
            throw new IllegalArgumentException("Hamburguer invalido");
        }
        return (Hamburguer) objeto;
    }
}
