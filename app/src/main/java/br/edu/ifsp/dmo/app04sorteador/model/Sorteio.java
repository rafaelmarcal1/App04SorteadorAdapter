package br.edu.ifsp.dmo.app04sorteador.model;

import java.util.ArrayList;
import java.util.List;

public class Sorteio {
    private SorteioStrategy strategy;
    private List<Integer> history;

    public Sorteio(){
        strategy = DefaultLimit.getInstance();
        history = new ArrayList<>(20);
    }

    public Sorteio(int border){
        strategy = new DefinedLimit(border);
        history = new ArrayList<>(20);
    }

    public int getNumber(){
        int n = strategy.nextNumber();
        history.add(n);
        return n;
    }

    public List<Integer> getHistory(){
        return history;
    }

    public int getLowBorder(){
        return strategy.getLowBorder();
    }

    public int getHighBorder(){
        return strategy.getHighBorder();
    }
}