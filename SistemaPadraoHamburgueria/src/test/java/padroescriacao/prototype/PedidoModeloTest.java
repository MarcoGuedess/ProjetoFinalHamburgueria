package padroescriacao.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoModeloTest {

    @Test
    void deveClonarPedidoModelo() {
        PedidoModelo modelo = new PedidoModelo("Combo da casa", "X-Bacon", "Refrigerante");
        PedidoModelo clone = modelo.clonar();
        clone.setNome("Combo promocional");

        assertEquals("Combo da casa: X-Bacon + Refrigerante", modelo.getResumo());
        assertEquals("Combo promocional: X-Bacon + Refrigerante", clone.getResumo());
    }

    @Test
    void deveCriarCloneComoOutraInstancia() {
        PedidoModelo modelo = new PedidoModelo("Combo da casa", "X-Bacon", "Refrigerante");
        PedidoModelo clone = modelo.clonar();

        assertNotSame(modelo, clone);
        assertEquals(modelo.getResumo(), clone.getResumo());
    }

    @Test
    void deveAlterarModeloSemAlterarCloneCriadoAntes() {
        PedidoModelo modelo = new PedidoModelo("Combo da casa", "X-Bacon", "Refrigerante");
        PedidoModelo clone = modelo.clonar();

        modelo.setNome("Combo especial");

        assertEquals("Combo especial: X-Bacon + Refrigerante", modelo.getResumo());
        assertEquals("Combo da casa: X-Bacon + Refrigerante", clone.getResumo());
    }
}
