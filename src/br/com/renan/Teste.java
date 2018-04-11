package br.com.renan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teste {

    public static void main(String[] args) {
        Estoque listaEstoque = new Estoque();
        ArrayList<Produto> estoque = listaEstoque.getEstoque();
        int opcao = 0;
        while (opcao != 5) {
            apresentarMenu();
            opcao = receberOpcao();
            menu(opcao, estoque);
        }
//        Produto prod = estoque.get(0);
//        if (prod instanceof Alimento) {
//            Alimento al = (Alimento) prod;
//            System.out.println(al.isPerecivel());
//        } else if (prod instanceof Higiene) {
//            Higiene hig = (Higiene) prod;
//            System.out.println(hig.getVencimento());
//        }

    }

    public static void apresentarMenu() {
        System.out.println("=========== MENU ===========\n");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Alterar Quantidade");
        System.out.println("3 - Gerar Listagem de Produtos");
        System.out.println("4 - Verificar Vencimentos");
        System.out.println("5 - Sair");
    }

    public static int receberOpcao() {
        int opcao = 0;
        try {
            Scanner console = new Scanner(System.in);
            System.out.println("\nDigite a opção desejada: ");
            opcao = console.nextInt();
        } catch (Exception ex) {
            System.out.println("\n** Entrada inválida! **");
        }
        return opcao;
    }

    public static void menu(int opcao, ArrayList<Produto> estoque) {
        Scanner console = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        switch (opcao) {
            case 1:
                menuCadastrar();
                int opcaoCadastrar = receberOpcao();
                switch (opcaoCadastrar) {
                    case 1:
                        try {
                            System.out.println("\n====== CADASTRAR ALIMENTO =====\n");
                            String nomeAlimento;
                            double pesoAlimento;
                            int qtdAlimento;
                            Date vctoAlimento = new Date();
                            boolean perecAlimento = false;
                            System.out.print("Digite o nome do alimento: ");
                            nomeAlimento = console.nextLine();
                            System.out.print("Digite o peso do alimento: ");
                            pesoAlimento = Double.parseDouble(console.nextLine());
                            System.out.print("Digite a quantidade do alimento: ");
                            qtdAlimento = console.nextInt();
                            System.out.println("Digite a data de vencimento do alimento (yyyy-MM-dd): ");
                            {
                                try {
                                    vctoAlimento = sdf.parse(console.next());
                                } catch (ParseException ex) {
                                    Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            System.out.println("O produto é perecível? 1 - Sim / 2 - Não");
                            int perec = console.nextInt();
                            if (perec == 1) {
                                perecAlimento = true;
                            } else if (perec == 2) {
                                perecAlimento = false;
                            }
                            Produto alimento = new Alimento(nomeAlimento, pesoAlimento, qtdAlimento, vctoAlimento, perecAlimento);
                            estoque.add(alimento);
                            System.out.println("\nProduto cadastrado com sucesso!\n");
                            break;
                        } catch (Exception ex) {

                        }
                    case 2:
                        try {
                            System.out.println("\n====== CADASTRAR PRODUTO HIGIÊNICO =====\n");
                            String nomeHigiene;
                            double pesoHigiene;
                            int qtdHigiene;
                            Date vctoHigiene = new Date();
                            System.out.print("Digite o nome do produto de higiene: ");
                            nomeHigiene = console.nextLine();
                            System.out.print("Digite o peso do produto de higiene: ");
                            pesoHigiene = Double.parseDouble(console.nextLine());
                            System.out.print("Digite a quantidade do produto de higiene: ");
                            qtdHigiene = console.nextInt();
                            System.out.println("Digite a data de vencimento do produto de higiene (yyyy-MM-dd): ");
                            {
                                try {
                                    vctoHigiene = sdf.parse(console.next());
                                } catch (ParseException ex) {
                                    Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (Exception e) {
                                    System.out.println("Erro.");
                                }
                            }
                            Produto prodHig = new Higiene(nomeHigiene, pesoHigiene, qtdHigiene, vctoHigiene);
                            estoque.add(prodHig);
                            System.out.println("\n** Produto cadastrado com sucesso! **\n");
                            break;
                        } catch (Exception ex) {

                        }
                    default:
                        System.out.println("\n** Opção inválida. **");
                        break;
                }
                break;
            case 2:
                try {
                    if (!estoque.isEmpty()) {
                        System.out.println("Digite o nome do produto a ter sua quantidade alterada: ");
                        String nomeProd = console.nextLine();
                        for (Produto prod : estoque) {
                            if (nomeProd.equals(prod.getNome())) {
                                int qtdProd = prod.getQuantidade();
                                System.out.printf("Produto encontrado. Quantidade atual: %d \n", qtdProd);
                                System.out.print("Digite a nova quantidade: ");
                                int novaQtd = console.nextInt();
                                prod.setQuantidade(novaQtd);
                                System.out.println("Quantidade alterada com sucesso!\n");
                            } else {
                                System.out.println("Produto não encontrado.\n");
                            }
                        }
                    } else {
                        System.out.println("\n** Lista vazia! **\n");
                    }
                    break;
                } catch (Exception ex) {

                }
            case 3:
                try {
                    Estoque estq = new Estoque();
                    estq.imprimirListagem(estoque);
                    break;
                } catch (Exception ex) {

                }
            case 4:
                try {
                    Estoque estq = new Estoque();
                    Date dataAtual = new Date();
                    System.out.println("\nQuantos dias para o vencimento?");
                    int dias = console.nextInt();
                    estq.gerarVctos(estoque, dataAtual, dias);
                    System.out.println("\n** Listagem gerada com sucesso! **");
                } catch (Exception ex) {

                }
                break;
            default:
                System.out.println("\n** Entrada inválida! **\n");
                break;
        }
    }

    public static void menuCadastrar() {
        System.out.println("");
        System.out.println("1 - Cadastrar Alimento");
        System.out.println("2 - Cadastrar Higiene");
    }

}
