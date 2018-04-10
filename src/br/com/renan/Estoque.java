package br.com.renan;

import java.util.ArrayList;

public class Estoque {
    
    private ArrayList<Produto> estoque = new ArrayList<Produto>();

    public ArrayList<Produto> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Produto> estoque) {
        this.estoque = estoque;
    }

}
