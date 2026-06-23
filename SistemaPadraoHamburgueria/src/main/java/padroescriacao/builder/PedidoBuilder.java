package padroescriacao.builder;

public class PedidoBuilder {

    private Pedido pedido;

    public PedidoBuilder() {
        pedido = new Pedido();
    }

    public Pedido build() {
        if (pedido.getNumero() == 0) {
            throw new IllegalArgumentException("Numero do pedido invalido");
        }
        if (pedido.getCliente().equals("")) {
            throw new IllegalArgumentException("Cliente invalido");
        }
        if (pedido.getHamburguer().equals("")) {
            throw new IllegalArgumentException("Hamburguer invalido");
        }
        return pedido;
    }

    public PedidoBuilder setNumero(int numero) {
        pedido.setNumero(numero);
        return this;
    }

    public PedidoBuilder setCliente(String cliente) {
        pedido.setCliente(cliente);
        return this;
    }

    public PedidoBuilder setHamburguer(String hamburguer) {
        pedido.setHamburguer(hamburguer);
        return this;
    }

    public PedidoBuilder setBebida(String bebida) {
        pedido.setBebida(bebida);
        return this;
    }

    public PedidoBuilder setEnderecoEntrega(String enderecoEntrega) {
        pedido.setEnderecoEntrega(enderecoEntrega);
        return this;
    }

    public PedidoBuilder setValor(float valor) {
        pedido.setValor(valor);
        return this;
    }
}
