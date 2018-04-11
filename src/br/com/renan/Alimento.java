package br.com.renan;

import java.util.Date;

public class Alimento extends Produto {

    private boolean perecivel;

    public Alimento(String nome, double peso, int quantidade, Date vencimento, boolean perecivel) {
        super(nome, peso, quantidade, vencimento);
        this.perecivel = perecivel;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }

}
