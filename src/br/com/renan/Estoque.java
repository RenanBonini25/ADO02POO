package br.com.renan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Estoque {

    private ArrayList<Produto> estoque = new ArrayList<Produto>();

    public ArrayList<Produto> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Produto> estoque) {
        this.estoque = estoque;
    }

    public void gerarVctos(ArrayList<Produto> estoque, Date dataAtual, int dias) {
        if (!estoque.isEmpty()) {
        String vencimentosProdutos = "vencimentosProdutos.txt";
        try {
            FileWriter fileWriter = new FileWriter(vencimentosProdutos);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("====================== VENCIMENTOS DE PRODUTOS ================================");
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            for (Produto prod : estoque) {
                String tipoProd = "";
                if (prod instanceof Alimento) {
                    tipoProd = "Alimento";
                } else if (prod instanceof Higiene) {
                    tipoProd = "Produto de Higiene";
                }
                int difDias = (int) ((prod.getVencimento().getTime() - dataAtual.getTime())
                        / (1000 * 60 * 60 * 24));
                difDias = difDias + 1;
                bufferedWriter.write("Tipo: " + tipoProd);
                bufferedWriter.newLine();
                bufferedWriter.write("Nome: " + prod.getNome());
                bufferedWriter.newLine();
                if (difDias <= dias && difDias >= 1) {
                    if (prod instanceof Alimento) {
                        Alimento alimento = (Alimento) prod;
                        bufferedWriter.write("Perecível: " + alimento.isPerecivel());
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write("** O produto irá vencer em " + difDias + " dias! **");
                    bufferedWriter.newLine();
                } else if (difDias < 1) {
                    bufferedWriter.write("** O produto já está vencido! **");
                    bufferedWriter.newLine();
                }
                bufferedWriter.write("=======================================");
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception ex) {
            System.out.println("erro");
        }
        } else {
            System.out.println("\n** A lista está vazia! **\n");
        }

    }

    public void imprimirListagem(ArrayList<Produto> estoque) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String listagemProdutos = "listagemProdutos.txt";
        if (!estoque.isEmpty()) {
            try {
                FileWriter fileWriter = new FileWriter(listagemProdutos);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("====================== LISTAGEM DE PRODUTOS ================================");
                bufferedWriter.newLine();
                bufferedWriter.newLine();

                for (Produto prod : estoque) {
                    String tipoProd = "";
                    if (prod instanceof Alimento) {
                        tipoProd = "Alimento";
                    } else if (prod instanceof Higiene) {
                        tipoProd = "Produto de Higiene";
                    }
                    bufferedWriter.write("Tipo: " + tipoProd);
                    bufferedWriter.newLine();
                    bufferedWriter.write("Nome: " + prod.getNome());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Peso: " + prod.getPeso());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Quantidade: " + prod.getQuantidade());
                    bufferedWriter.newLine();
                    String vctoProd = sdf.format(prod.getVencimento());
                    bufferedWriter.write("Vencimento: " + vctoProd);
                    bufferedWriter.newLine();
                    if (prod instanceof Alimento) {
                        Alimento alimento = (Alimento) prod;
                        bufferedWriter.write("Perecível: " + alimento.isPerecivel());
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write("======================================================");
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                System.out.println("\n** Listagem gerada com sucesso! **\n");
            } catch (Exception ex) {

            }
        } else {
            System.out.println("\n** Lista vazia! **\n");
        }
    }
}
