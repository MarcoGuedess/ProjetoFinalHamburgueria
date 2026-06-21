package br.com.hamburgueria.promocao.chainofresponsibility;

import br.com.hamburgueria.dominio.Pedido;


// Pattern 13: Chain of Responsibility
public abstract class ValidacaoPedidoChain {
    protected ValidacaoPedidoChain proximo;

    public ValidacaoPedidoChain encadear(ValidacaoPedidoChain proximo) {
        this.proximo = proximo;
        return this.proximo;
    }

    public abstract boolean validar(Pedido pedido);

    protected boolean checarProximo(Pedido pedido) {
        if (proximo == null) {
            return true;
        }
        return proximo.validar(pedido);
    }
}


