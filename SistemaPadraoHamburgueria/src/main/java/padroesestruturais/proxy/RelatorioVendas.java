package padroesestruturais.proxy;

public class RelatorioVendas implements Relatorio {

    public String emitir(String cargo) {
        return "Relatorio de vendas emitido";
    }
}
