package padroesestruturais.proxy;

public class RelatorioVendasProxy implements Relatorio {

    private RelatorioVendas relatorio = new RelatorioVendas();

    public String emitir(String cargo) {
        if (!cargo.equals("gerente")) {
            throw new IllegalArgumentException("Acesso negado");
        }
        return relatorio.emitir(cargo);
    }
}
