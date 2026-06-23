package padroescriacao.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComboTest {

    @Test
    void deveCriarComboTradicional() {
        Combo combo = new Combo(new ComboTradicionalFactory());
        assertEquals("Hamburguer tradicional com Refrigerante", combo.getDescricao());
    }

    @Test
    void deveCriarComboVegano() {
        Combo combo = new Combo(new ComboVeganoFactory());
        assertEquals("Hamburguer vegano com Suco natural", combo.getDescricao());
    }
}
