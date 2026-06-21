package br.com.hamburgueria.estoque.flyweight;

// Pattern 11: Flyweight
public class IngredienteFlyweight {
    private final String nome;
    private final int caloriasAdicionais;
    // Foto, informações nutricionais longas, fornecedor, etc poderiam vir aqui

    public IngredienteFlyweight(String nome, int caloriasAdicionais) {
        this.nome = nome;
        this.caloriasAdicionais = caloriasAdicionais;
    }

    public String getNome() {
        return nome;
    }

    public int getCaloriasAdicionais() {
        return caloriasAdicionais;
    }
}

