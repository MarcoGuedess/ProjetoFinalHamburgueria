package br.com.hamburgueria.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Dinheiro {
    private final BigDecimal quantia;

    private Dinheiro(BigDecimal quantia) {
        this.quantia = quantia.setScale(2, RoundingMode.HALF_EVEN);
    }

    public static Dinheiro reais(double valor) {
        return new Dinheiro(BigDecimal.valueOf(valor));
    }

    public static Dinheiro reais(BigDecimal valor) {
        return new Dinheiro(valor);
    }

    public BigDecimal getQuantia() {
        return quantia;
    }

    public Dinheiro somar(Dinheiro outro) {
        return new Dinheiro(this.quantia.add(outro.quantia));
    }

    public Dinheiro subtrair(Dinheiro outro) {
        return new Dinheiro(this.quantia.subtract(outro.quantia));
    }

    public Dinheiro multiplicar(double fator) {
        return new Dinheiro(this.quantia.multiply(BigDecimal.valueOf(fator)));
    }

    public boolean maiorOuIgual(Dinheiro outro) {
        return this.quantia.compareTo(outro.quantia) >= 0;
    }

    public boolean maior(Dinheiro outro) {
        return this.quantia.compareTo(outro.quantia) > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return quantia.equals(dinheiro.quantia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantia);
    }

    @Override
    public String toString() {
        return "R$ " + quantia.toString();
    }
}
