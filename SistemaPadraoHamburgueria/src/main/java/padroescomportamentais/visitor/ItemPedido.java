package padroescomportamentais.visitor;

public interface ItemPedido {

    float aceitar(VisitorPedido visitor);

    float getPreco();
}
