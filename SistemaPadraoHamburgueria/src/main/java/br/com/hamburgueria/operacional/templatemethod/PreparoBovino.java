package br.com.hamburgueria.operacional.templatemethod;

import br.com.hamburgueria.dominio.Cliente;
import br.com.hamburgueria.operacional.templatemethod.PreparoLancheTemplate;

public class PreparoBovino extends PreparoLancheTemplate {
    @Override
    protected void prepararCarne() {
        System.out.println("Grelhando hambúrguer bovino ao ponto do cliente.");
    }
}


