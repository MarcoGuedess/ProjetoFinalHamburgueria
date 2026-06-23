package padroescomportamentais.mediator;

public class Cozinha extends Setor {

    public Cozinha(CentralPedidos centralPedidos) {
        super(centralPedidos);
    }

    public String getNome() {
        return "Cozinha";
    }
}
