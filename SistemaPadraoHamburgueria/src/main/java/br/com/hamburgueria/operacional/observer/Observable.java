package br.com.hamburgueria.operacional.observer;

import br.com.hamburgueria.dominio.Pedido;
import br.com.hamburgueria.operacional.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notificar(Pedido pedido) {
        for (Observer observer : observers) {
            observer.atualizar(pedido);
        }
    }
}


