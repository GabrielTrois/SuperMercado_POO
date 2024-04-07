package br.com.mercado.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import br.com.mercado.principais.CartaoFidelidade;
import br.com.mercado.principais.Produto;
import br.com.mercado.principais.ProdutoLanchonete;
import br.com.mercado.principais.ProdutoNaoPerecivel;
import br.com.mercado.repositorio.Estoque;
import br.com.mercado.repositorio.Relatorio;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<CartaoFidelidade> cartao = new ArrayList<>();
        Relatorio relatorio = new Relatorio();
        
        String file = "src\\Lista-Produtos.csv";
        try {
        	Scanner scanner = new Scanner(new File(file));
        	
        	scanner.useDelimiter(",");
        	
        	while(scanner.hasNext()) {
        		String nome = scanner.next();
        		String lote = scanner.next();
        		String q = scanner.next();
        		int quantidade = Integer.parseInt(q);
        		String p = scanner.next();
        		double precoUnitario = Double.parseDouble(p);
        		String dataFabricacao = scanner.next();
        		String dataVencimento = scanner.next();
        		String tipo = scanner.nextLine();

        		if(tipo.equals(",1")) {
        			produtos.add(new Produto(nome, lote, quantidade, precoUnitario, sdf.parse(dataFabricacao), sdf.parse(dataVencimento)));
        		} else if (tipo.equals(",2")) {
        			produtos.add(new ProdutoNaoPerecivel(nome, lote, quantidade, precoUnitario, sdf.parse(dataFabricacao)));
        		} else if (tipo.equals(",3")) {
        			produtos.add(new ProdutoLanchonete(nome, quantidade, precoUnitario, sdf.parse(dataFabricacao), sdf.parse(dataVencimento)));
        		}
        		
        		Collections.reverse(produtos);
        	}
        	
        	scanner.close();
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
            e.printStackTrace();
        }

        Produto.listaProdutosVencimento(produtos);

        int opcao = 0;

        do {
            System.out.println("Bem-vindo ao CltrEasy! Seu controle fácil de validade de produtos");
            System.out.println();
            System.out.println("================================");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Buscar produto");
            System.out.println("5 - Listar produtos");
            System.out.println("6 - Relatórios");
            System.out.println("7 - Sair");
            System.out.println("================================");
            System.out.println();

            System.out.print("Digite a opção desejada: ");
            System.out.println();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Estoque.adicionarProduto(produtos, sc, sdf);
                    break;

                case 2:
                    Estoque.removerProduto(produtos, sc);
                    break;

                case 3:
                    Produto.atualizarProduto(produtos, sc, sdf);
                    break;

                case 4:
                    Estoque.buscarProduto(produtos, sc);
                    break;

                case 5:
                    Estoque.listaProdutos(produtos);
                    break;
                case 6:
                    Estoque estoque = new Estoque();
                    estoque.atualizarEstoque(produtos, relatorio);
                    relatorio.imprimirRelatorio(produtos);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Digite qualquer coisa para continuar");
            sc.next();

        } while (opcao != 7);

        System.out.println("+-----------------------------+");
        System.out.println("Obrigado por usar o Cltreasy!");
        System.out.println("+-----------------------------+");

        sc.close();
    }

}

