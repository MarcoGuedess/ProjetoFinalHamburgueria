package br.com.hamburgueria.estoque.singleton;

import br.com.hamburgueria.estoque.proxy.AcessoEstoque;

import java.util.HashMap;
import java.util.Map;

// Pattern 1: Singleton
public class GerenciadorEstoque implements AcessoEstoque {
    private static GerenciadorEstoque instancia;
    private final Map<String, Integer> inventario;

    private GerenciadorEstoque() {
        inventario = new HashMap<>();
        // Estoque inicial
        inventario.put("Pão Tradicional", 100);
        inventario.put("Carne Bovina", 100);
        inventario.put("Hambúrguer Vegano", 50);
        inventario.put("Bacon", 200);
        inventario.put("Cheddar", 200);
    }

    public static synchronized GerenciadorEstoque getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorEstoque();
        }
        return instancia;
    }

    public boolean temEstoque(String ingrediente, int quantidade) {
        return inventario.getOrDefault(ingrediente, 0) >= quantidade;
    }

    public void darBaixa(String ingrediente, int quantidade) {
        if (!temEstoque(ingrediente, quantidade)) {
            throw new RuntimeException("Estoque insuficiente para: " + ingrediente);
        }
        inventario.put(ingrediente, inventario.get(ingrediente) - quantidade);
    }

    public void adicionarEstoque(String ingrediente, int quantidade) {
        inventario.put(ingrediente, inventario.getOrDefault(ingrediente, 0) + quantidade);
    }
}


