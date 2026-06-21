package br.com.hamburgueria.operacional.mediator;

import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.operacional.templatemethod.PreparoBovino;
import br.com.hamburgueria.operacional.templatemethod.PreparoLancheTemplate;


// Pattern 17: Mediator
public class CentralOperacoesMediator {
    
    public void notificarCaixa(Pedido pedido) {
        System.out.println("[MEDIATOR] Avisando o Caixa que o pedido do " + pedido.getCliente().getNome() + " foi pago.");
    }

    public void notificarCozinha(Pedido pedido) {
        System.out.println("[MEDIATOR] Enviando pedido para a fila da Cozinha.");
        // A cozinha agora sabe que tem que fazer o pedido
        PreparoLancheTemplate preparo = new PreparoBovino(); // simplificação
        preparo.preparar();
        pedido.getEstado().pronto(pedido);
    }

    public void notificarDelivery(Pedido pedido) {
        System.out.println("[MEDIATOR] Acionando motoboy para entrega via " + pedido.getClass().getSimpleName());
        pedido.despacharPedido();
        pedido.getEstado().entregar(pedido);
    }
}


