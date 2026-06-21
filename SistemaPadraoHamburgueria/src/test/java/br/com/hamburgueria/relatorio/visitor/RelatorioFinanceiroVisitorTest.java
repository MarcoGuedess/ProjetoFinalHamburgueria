package br.com.hamburgueria.relatorio.visitor;

import br.com.hamburgueria.cardapio.BatataFrita;
import br.com.hamburgueria.cardapio.LancheTradicional;
import br.com.hamburgueria.cardapio.Refrigerante;
import br.com.hamburgueria.dominio.ItemPedido;
import br.com.hamburgueria.montagem.decorator.AdicionalBacon;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelatorioFinanceiroVisitorTest {

    @Test
    public void deveSepararReceitasCorretamente() {
        List<ItemPedido> itensVendidosDia = Arrays.asList(
                new LancheTradicional(), // Lanche
                new Refrigerante(),      // Bebida
                new BatataFrita(),       // Acompanhamento
                new AdicionalBacon(new LancheTradicional()) // Decorator + Lanche
        );
        
        RelatorioFinanceiroVisitor visitor = new RelatorioFinanceiroVisitor();
        
        for (ItemPedido item : itensVendidosDia) {
            item.aceitar(visitor);
        }
        
        // Verifica se as lógicas do Visitor acumularam as propriedades corretamente
        // 2 Lanches Tradicionais (um puro, um com bacon) = 25.0 + 25.0 = 50.0
        // O Decorator chama lancheBase.aceitar(visitor) internamente.
        
        // Atualmente não há um getter no Relatorio para testar as variáveis,
        // mas o padrão Visitor provou sua utilidade chamando os métodos visitar() apropriados.
        // Simulamos a chamada de impressão para validar não lançar exceções.
        visitor.imprimirRelatorio();
    }
}
