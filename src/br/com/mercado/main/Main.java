package br.com.mercado.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.mercado.cliente.Pessoa;
import br.com.mercado.principais.CartaoFidelidade;
import br.com.mercado.principais.Produto;
import br.com.mercado.principais.ProdutoLanchonete;
import br.com.mercado.principais.ProdutoNaoPerecivel;
import br.com.mercado.repositorio.Estoque;
import br.com.mercado.repositorio.Relatorio;
import br.com.mercado.repositorio.RepositorioFidelidade;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<CartaoFidelidade> cartoes = new ArrayList<>();
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
        	
        	Pessoa p = new Pessoa();
        	p.setNome("João Silva");
        	p.setCpf("123-456-789-00");
        	p.setIdade(29);
        	
        	cartoes.add(new CartaoFidelidade(p, 345, 12345, 15));
        	
        	scanner.close();
        	
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
            e.printStackTrace();
        }
        
        int menu = 1;
        int opcao = 0;
        
        do {
        	if(menu == 1) {

        		Produto.listaProdutosVencimento(produtos);
	
	            System.out.println("Bem-vindo ao sistema controle de validade de produtos");
	            System.out.println();
	            System.out.println("================================");
	            System.out.println("1 - Cadastrar produto");
	            System.out.println("2 - Remover produto");
	            System.out.println("3 - Atualizar produto");
	            System.out.println("4 - Buscar produto");
	            System.out.println("5 - Listar produtos");
	            System.out.println("6 - Relatórios");
	            System.out.println("7 - Menu Fidelidade");
	            System.out.println("8 - Sair");
	            System.out.println("================================");
	            System.out.println();
	
	            System.out.print("Digite a opção desejada: ");
	            System.out.println();
	            try {
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
		                    
		                case 7:
		                    menu = 2;
		                    break;
		                
		                case 8:
		                    menu = 3;
		                    break;
		
		                default:
		                    System.out.println("Opção inválida.");
		            }
	            } catch (InputMismatchException e) {
	            	System.out.println("Opção inválida.");
				}
	            
    		} else if (menu == 2) {
	            System.out.println("\nBem-vindo ao sistema de controle cartões de fidelidade");
	            System.out.println();
	            System.out.println("================================");
	            System.out.println("1 - Cadastrar cartão fidelidade");
	            System.out.println("2 - Cancelar cartão fidelidade");
	            System.out.println("3 - Buscar cartão");
	            System.out.println("4 - Listar cartões");
	            System.out.println("5 - Mostrar desconto dos clientes");
	            System.out.println("6 - Menu Fidelidade");
	            System.out.println("7 - Sair");
	            System.out.println("================================");
	            System.out.println();
	
	            System.out.print("Digite a opção desejada: ");
	            System.out.println();
	            try {
	            	opcao = sc.nextInt();

		            switch (opcao) {
	                case 1:
	                    RepositorioFidelidade.criarCartao(cartoes);
	                    break;
	
	                case 2:
	                    RepositorioFidelidade.cancelarCartao(cartoes);
	                    break;
	
	                case 3:
	                	RepositorioFidelidade.buscarCartao(cartoes, sc);
	                    break;
	
	                case 4:
	                	RepositorioFidelidade.listarCartoes(cartoes);
	                    break;
	                    
	                case 5:
	                	int i = 0;
	                	for(CartaoFidelidade cf : cartoes) {
	                		cf.imprimirCartao(i);
	                		System.out.println("Desconto: " + (cf.calcularDesconto()*100) + "%");
	                		i += 1;
	                	}
	                    break;
	                    
	                case 6:
	                    menu = 1;
	                    break;
	                    
	                case 7:
	                    menu = 3;
	                    break;
	
	                default:
	                    System.out.println("Opção inválida.");
		            }
	            } catch (InputMismatchException e) {
	            	System.out.println("Opção inválida.");
				}
        	}
        	
        	System.out.println("Digite qualquer coisa para continuar");
            sc.next();
            clearConsole();
            
        }while (menu != 3);
	        

        System.out.println("+-----------------------------+");
        System.out.println("Programa encerrado!");
        System.out.println("+-----------------------------+");

        sc.close();
    }
    
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");
            
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
}

