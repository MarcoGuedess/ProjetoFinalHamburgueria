package padroesestruturais.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancheBridgeTest {

    @Test
    void devePrepararLancheCarneNaChapa() {
        Lanche lanche = new LancheCarne(new PreparoChapa());
        assertEquals("Lanche de carne preparado na chapa", lanche.montar());
    }

    @Test
    void devePrepararLancheFrangoNaGrelha() {
        Lanche lanche = new LancheFrango(new PreparoGrelha());
        assertEquals("Lanche de frango preparado na grelha", lanche.montar());
    }
}
