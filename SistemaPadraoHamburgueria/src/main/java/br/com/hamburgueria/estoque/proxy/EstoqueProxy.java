package br.com.hamburgueria.estoque.proxy;

import br.com.hamburgueria.estoque.proxy.AcessoEstoque;
import br.com.hamburgueria.estoque.singleton.GerenciadorEstoque;

// Pattern 12: Proxy
public class EstoqueProxy implements AcessoEstoque {
    private final GerenciadorEstoque gerenciadorReal;
    private final String usuarioAtendente;

    public EstoqueProxy(String usuarioAtendente) {
        this.gerenciadorReal = GerenciadorEstoque.getInstancia();
        this.usuarioAtendente = usuarioAtendente;
    }

    @Override
    public boolean temEstoque(String ingrediente, int quantidade) {
        return gerenciadorReal.temEstoque(ingrediente, quantidade);
    }

    @Override
    public void darBaixa(String ingrediente, int quantidade) {
        System.out.println("[LOG] Usuário " + usuarioAtendente + " solicitando baixa de " + quantidade + "x " + ingrediente);
        gerenciadorReal.darBaixa(ingrediente, quantidade);
    }
}


