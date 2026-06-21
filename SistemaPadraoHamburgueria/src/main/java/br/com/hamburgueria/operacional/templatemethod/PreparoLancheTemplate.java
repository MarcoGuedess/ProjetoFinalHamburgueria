package br.com.hamburgueria.operacional.templatemethod;

import br.com.hamburgueria.cardapio.Lanche;

// Pattern 22: Template Method
public abstract class PreparoLancheTemplate {
    
    public final void preparar() {
        separarPao();
        prepararCarne();
        montarLanche();
        embalar();
    }

    private void separarPao() {
        System.out.println("Separando e tostando o pão.");
    }

    // Passivo de ser sobrescrito
    protected abstract void prepararCarne();

    private void montarLanche() {
        System.out.println("Montando lanche com acompanhamentos e molhos.");
    }

    private void embalar() {
        System.out.println("Embalando o lanche finalizado.");
    }
}


