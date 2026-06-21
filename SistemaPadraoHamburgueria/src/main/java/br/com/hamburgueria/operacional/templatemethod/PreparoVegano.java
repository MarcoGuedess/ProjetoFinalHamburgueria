package br.com.hamburgueria.operacional.templatemethod;

import br.com.hamburgueria.operacional.templatemethod.PreparoLancheTemplate;

public class PreparoVegano extends PreparoLancheTemplate {
    @Override
    protected void prepararCarne() {
        System.out.println("Assando hambúrguer de grão de bico na chapa separada.");
    }
}


