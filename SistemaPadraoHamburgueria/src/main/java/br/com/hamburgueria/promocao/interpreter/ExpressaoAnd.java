package br.com.hamburgueria.promocao.interpreter;

import br.com.hamburgueria.promocao.interpreter.Expressao;

public class ExpressaoAnd implements Expressao {
    private Expressao exp1;
    private Expressao exp2;

    public ExpressaoAnd(Expressao exp1, Expressao exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public boolean interpretar(String contexto) {
        return exp1.interpretar(contexto) && exp2.interpretar(contexto);
    }
}


