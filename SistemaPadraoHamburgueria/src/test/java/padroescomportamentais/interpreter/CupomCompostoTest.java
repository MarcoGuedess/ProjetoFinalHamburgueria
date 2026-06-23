package padroescomportamentais.interpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CupomCompostoTest {

    @Test
    void deveInterpretarDescontoValor() {
        ExpressaoDesconto desconto = new DescontoValor(10.0f);
        assertEquals(40.0f, desconto.interpretar(50.0f));
    }

    @Test
    void deveInterpretarTaxaEntrega() {
        ExpressaoDesconto taxa = new TaxaEntrega(5.0f);
        assertEquals(55.0f, taxa.interpretar(50.0f));
    }

    @Test
    void deveInterpretarCupomComDescontoETaxa() {
        ExpressaoDesconto cupom = new CupomComposto(new DescontoValor(10.0f), new TaxaEntrega(5.0f));
        assertEquals(45.0f, cupom.interpretar(50.0f));
    }

    @Test
    void deveInterpretarCupomComTaxaEDesconto() {
        ExpressaoDesconto cupom = new CupomComposto(new TaxaEntrega(8.0f), new DescontoValor(3.0f));
        assertEquals(55.0f, cupom.interpretar(50.0f));
    }
}
