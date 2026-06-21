package br.com.hamburgueria.config.singleton;

// Pattern 1: Singleton (Alternativa)
public class ConfiguracaoLoja {
    private static final ConfiguracaoLoja instancia = new ConfiguracaoLoja();
    
    private String nomeLoja = "Sistema Padrão Hamburgueria";
    private boolean lojaAberta = true;

    private ConfiguracaoLoja() {}

    public static ConfiguracaoLoja getInstancia() {
        return instancia;
    }

    public boolean isLojaAberta() {
        return lojaAberta;
    }

    public void setLojaAberta(boolean lojaAberta) {
        this.lojaAberta = lojaAberta;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }
}

