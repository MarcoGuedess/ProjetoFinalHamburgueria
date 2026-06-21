package br.com.hamburgueria.estoque.proxy;

// Interface para o Proxy e o Sujeito Real
public interface AcessoEstoque {
    boolean temEstoque(String ingrediente, int quantidade);
    void darBaixa(String ingrediente, int quantidade);
}

