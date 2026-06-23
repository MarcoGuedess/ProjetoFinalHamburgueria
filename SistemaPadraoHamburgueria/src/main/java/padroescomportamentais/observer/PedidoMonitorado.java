package padroescomportamentais.observer;

import java.util.ArrayList;
import java.util.List;

public class PedidoMonitorado {

    private String status;
    private List<Setor> setores = new ArrayList<Setor>();

    public void adicionarSetor(Setor setor) {
        setores.add(setor);
    }

    public void setStatus(String status) {
        this.status = status;
        notificarSetores();
    }

    public String getStatus() {
        return status;
    }

    private void notificarSetores() {
        for (Setor setor : setores) {
            setor.atualizar(this);
        }
    }
}
