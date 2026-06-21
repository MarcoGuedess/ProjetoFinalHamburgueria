package br.com.hamburgueria.relatorio.visitor;

import br.com.hamburgueria.cardapio.Acompanhamento;
import br.com.hamburgueria.cardapio.Bebida;
import br.com.hamburgueria.cardapio.Cardapio;
import br.com.hamburgueria.cardapio.composite.Combo;
import br.com.hamburgueria.cardapio.Lanche;
import br.com.hamburgueria.montagem.decorator.IngredienteAdicionalDecorator;
import br.com.hamburgueria.relatorio.visitor.ItemPedidoVisitor;


public class RelatorioFinanceiroVisitor implements ItemPedidoVisitor {
    private double totalReceitaLanches = 0;
    private double totalReceitaBebidas = 0;
    private double totalReceitaAcompanhamentos = 0;
    private double totalReceitaAdicionais = 0;

    @Override
    public void visitar(Lanche lanche) {
        totalReceitaLanches += lanche.getPreco().getQuantia().doubleValue();
    }

    @Override
    public void visitar(Bebida bebida) {
        totalReceitaBebidas += bebida.getPreco().getQuantia().doubleValue();
    }

    @Override
    public void visitar(Acompanhamento acompanhamento) {
        totalReceitaAcompanhamentos += acompanhamento.getPreco().getQuantia().doubleValue();
    }

    @Override
    public void visitar(Combo combo) {
        // O combo em si não soma, a visita desce para os filhos, a menos que quiséssemos reportar os descontos aqui.
    }

    @Override
    public void visitar(IngredienteAdicionalDecorator decorator) {
        // Para calcular a receita só dos adicionais (subtraindo o base)
        // Isso é complexo mas demonstra o poder do visitor: extrair apenas a receita gerada por "adicionais".
        totalReceitaAdicionais += decorator.getPreco().getQuantia().doubleValue(); // simplificado
    }

    public void imprimirRelatorio() {
        System.out.println("=== Relatório Financeiro ===");
        System.out.println("Receita de Lanches: R$ " + totalReceitaLanches);
        System.out.println("Receita de Bebidas: R$ " + totalReceitaBebidas);
        System.out.println("Receita de Acompanhamentos: R$ " + totalReceitaAcompanhamentos);
        System.out.println("Receita Bruta com Adicionais (Sem descontos): R$ " + totalReceitaAdicionais);
    }
}


