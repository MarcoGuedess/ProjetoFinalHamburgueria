package br.com.hamburgueria.dominio;

import br.com.hamburgueria.atendimento.bridge.CanalEntrega;
import br.com.hamburgueria.atendimento.bridge.RetiradaBalcao;
import br.com.hamburgueria.atendimento.memento.PedidoMemento;
import br.com.hamburgueria.dominio.Cliente;
import br.com.hamburgueria.dominio.Dinheiro;
import br.com.hamburgueria.dominio.ItemPedido;
import br.com.hamburgueria.estado.state.EstadoNovo;
import br.com.hamburgueria.estado.state.PedidoState;


import java.util.ArrayList;
import java.util.List;

public class Pedido implements Cloneable {
    private List<ItemPedido> itens = new ArrayList<>();
    private PedidoState estado;
    private Cliente cliente;
    
    // Pattern 7: Bridge
    private CanalEntrega canalEntrega = new RetiradaBalcao(); // default

    // Pattern 4: Builder (O construtor é restrito)
    public Pedido() {
        this.estado = new EstadoNovo();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }

    public Dinheiro calcularTotal() {
        Dinheiro total = Dinheiro.reais(0.0);
        for (ItemPedido item : itens) {
            total = total.somar(item.getPreco());
        }
        return total;
    }

    public void setEstado(PedidoState estado) {
        this.estado = estado;
    }

    public PedidoState getEstado() {
        return estado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    // Pattern 7: Bridge methods
    public void setCanalEntrega(CanalEntrega canal) {
        this.canalEntrega = canal;
    }

    public void despacharPedido() {
        canalEntrega.enviarPedido("Pedido contendo " + itens.size() + " itens.");
    }

    public Dinheiro calcularTaxaEntrega() {
        Dinheiro totalItens = calcularTotal();
        return totalItens.multiplicar(canalEntrega.getTaxaCanal());
    }

    // Pattern 18: Memento methods
    public PedidoMemento salvarEstado() {
        return new PedidoMemento(this.itens);
    }

    public void restaurarEstado(PedidoMemento memento) {
        this.itens = memento.getItensSalvos();
    }

    // Pattern 5: Prototype
    @Override
    public Pedido clone() {
        try {
            Pedido clone = (Pedido) super.clone();
            clone.itens = new ArrayList<>(this.itens);
            clone.estado = new EstadoNovo(); // O clone nasce como um pedido novo
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

