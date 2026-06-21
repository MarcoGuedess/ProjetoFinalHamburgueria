package br.com.hamburgueria.promocao.chainofresponsibility;

import br.com.hamburgueria.config.singleton.ConfiguracaoLoja;
import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.promocao.chainofresponsibility.ValidacaoPedidoChain;


public class ValidarLojaAberta extends ValidacaoPedidoChain {
    @Override
    public boolean validar(Pedido pedido) {
        if (!ConfiguracaoLoja.getInstancia().isLojaAberta()) {
            System.out.println("[Validação] Loja fechada!");
            return false;
        }
        return checarProximo(pedido);
    }
}


