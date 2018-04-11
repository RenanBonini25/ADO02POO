package br.com.renan;

import java.util.Date;

public abstract class Produto {

    private String nome;
    private double peso;
    private int quantidade;
    private Date vencimento;

    public Produto(String nome, double peso, int quantidade, Date vencimento) {
        this.nome = nome;
        this.peso = peso;
        this.quantidade = quantidade;
        this.vencimento = vencimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

}
