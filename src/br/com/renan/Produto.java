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

    public boolean verificarVcto(Date dataAtual) {
        int difDias = (int) ((vencimento.getTime() - dataAtual.getTime())
                / (1000 * 60 * 60 * 24));
        if (difDias <= 7) {
            if (difDias >= 1) {
                System.out.printf("O produto irá vencer em %d dias!", difDias + 1);
            } else {
                System.out.println("O produto já está vencido!");
            }
            return true;
        } else {
            System.out.println("O produto não está perto de vencer!");
            return false;
        }
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
