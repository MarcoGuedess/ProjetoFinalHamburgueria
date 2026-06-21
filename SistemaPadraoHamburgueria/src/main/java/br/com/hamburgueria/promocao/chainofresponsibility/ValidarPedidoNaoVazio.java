package br.com.hamburgueria.promocao.chainofresponsibility;

import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.promocao.chainofresponsibility.ValidacaoPedidoChain;


public class ValidarPedidoNaoVazio extends ValidacaoPedidoChain {
    @Override
    public boolean validar(Pedido pedido) {
        if (pedido.getItens().isEmpty()) {
            System.out.println("[Validação] Pedido não contém itens!");
            return false;
        }
        return checarProximo(pedido);
    }
}


