package br.com.hamburgueria.promocao.chainofresponsibility;

import br.com.hamburgueria.cardapio.LancheTradicional;
import br.com.hamburgueria.config.singleton.ConfiguracaoLoja;
import br.com.hamburgueria.dominio.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidacaoPedidoChainTest {

    @Test
    public void deveValidarPedidoQuandoLojaAbertaETiverItens() {
        ConfiguracaoLoja.getInstancia().setLojaAberta(true);
        
        ValidacaoPedidoChain chain = new ValidarLojaAberta();
        chain.encadear(new ValidarPedidoNaoVazio());
        
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new LancheTradicional());
        
        assertTrue(chain.validar(pedido));
    }

    @Test
    public void naoDeveValidarPedidoQuandoLojaEstiverFechada() {
        ConfiguracaoLoja.getInstancia().setLojaAberta(false);
        
        ValidacaoPedidoChain chain = new ValidarLojaAberta();
        
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new LancheTradicional());
        
        assertFalse(chain.validar(pedido));
        
        // Restaura config para outros testes
        ConfiguracaoLoja.getInstancia().setLojaAberta(true);
    }
}
