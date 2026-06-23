package padroescriacao.prototype;

public class PedidoModelo implements Cloneable {

    private String nome;
    private String hamburguer;
    private String bebida;

    public PedidoModelo(String nome, String hamburguer, String bebida) {
        this.nome = nome;
        this.hamburguer = hamburguer;
        this.bebida = bebida;
    }

    public PedidoModelo clonar() {
        try {
            return (PedidoModelo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getResumo() {
        return nome + ": " + hamburguer + " + " + bebida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
