package br.com.hamburgueria.montagem.decorator;

import br.com.hamburgueria.cardapio.LancheTradicional;
import br.com.hamburgueria.dominio.ItemPedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredienteAdicionalDecoratorTest {

    @Test
    public void deveAumentarOPrecoEAsCaloriasQuandoAdicionarDecorator() {
        ItemPedido lancheBase = new LancheTradicional(); // Preço: 25.0, Calorias: 600
        
        ItemPedido lancheComBacon = new AdicionalBacon(lancheBase); // Preço Extra: 5.0, Calorias Extras: 100
        
        assertEquals("Hambúrguer Tradicional Bovino + Bacon Extra", lancheComBacon.getNome());
        assertEquals(30.0, lancheComBacon.getPreco().getQuantia().doubleValue(), 0.01);
        assertEquals(700, lancheComBacon.getCalorias());
    }
}
