package padroescomportamentais.mediator;

import java.util.ArrayList;
import java.util.List;

public class CentralPedidos {

    private List<Setor> setores = new ArrayList<Setor>();

    public void adicionarSetor(Setor setor) {
        setores.add(setor);
    }

    public void enviar(String mensagem, Setor remetente) {
        for (Setor setor : setores) {
            if (setor != remetente) {
                setor.receber(remetente.getNome() + ": " + mensagem);
            }
        }
    }
}
