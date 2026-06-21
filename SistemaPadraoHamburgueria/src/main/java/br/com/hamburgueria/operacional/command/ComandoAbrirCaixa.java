package br.com.hamburgueria.operacional.command;

import br.com.hamburgueria.operacional.command.AcaoCaixaCommand;

public class ComandoAbrirCaixa implements AcaoCaixaCommand {
    @Override
    public void executar() {
        System.out.println("[CAIXA] Abrindo o caixa para iniciar as operações do dia.");
    }
}


