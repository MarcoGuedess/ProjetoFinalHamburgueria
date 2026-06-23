package padroescomportamentais.templatemethod;

public abstract class PreparoLanche {

    public String preparar() {
        return separarIngredientes() + ", " + assarProteina() + ", " + montarLanche();
    }

    public String separarIngredientes() {
        return "Ingredientes separados";
    }

    public abstract String assarProteina();

    public String montarLanche() {
        return "Lanche montado";
    }
}
