package br.com.hamburgueria.promocao.interpreter;

import br.com.hamburgueria.promocao.interpreter.Expressao;

public class ExpressaoCupom implements Expressao {
    private String palavraChave;

    public ExpressaoCupom(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    @Override
    public boolean interpretar(String contexto) {
        return contexto.contains(palavraChave);
    }
}


