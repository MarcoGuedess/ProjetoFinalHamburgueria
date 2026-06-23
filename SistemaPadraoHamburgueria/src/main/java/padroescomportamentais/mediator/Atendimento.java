package padroescomportamentais.mediator;

public class Atendimento extends Setor {

    public Atendimento(CentralPedidos centralPedidos) {
        super(centralPedidos);
    }

    public String getNome() {
        return "Atendimento";
    }
}
