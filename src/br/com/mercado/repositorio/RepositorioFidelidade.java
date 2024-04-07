package br.com.mercado.repositorio;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.mercado.cliente.Pessoa;
import br.com.mercado.principais.CartaoFidelidade;
import br.com.mercado.principais.Produto;

public class RepositorioFidelidade {
	
	public static void criarCartao(ArrayList<CartaoFidelidade> cartoes) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nome do Cliente: ");
            String nome = sc.next();
            sc.nextLine();
            System.out.println("Cpf do Cliente: ");
            String cpf = sc.nextLine();
            System.out.println("Idade do Cliente: ");
            int idade = sc.nextInt();
            System.out.println("Id: ");
            int id = sc.nextInt();
            System.out.println("Senha: ");
            int senha = sc.nextInt();
            System.out.println("Compras feitas por cliente: ");
            int compras = sc.nextInt();
            
            Pessoa p = new Pessoa();
            p.setNome(nome);
            p.setCpf(cpf);
            p.setIdade(idade);
            
            cartoes.add(new CartaoFidelidade(p, id, senha, compras));
            
            sc.close();
            
        } catch (NumberFormatException e) {
            System.out.println("Digite valores validos.");
        }
	}
	
	public static void cancelarCartao(ArrayList<CartaoFidelidade> cartoes) {
		if(cartoes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		
		listarCartoes(cartoes);
		
		System.out.println("Digite o indice do cartão que quer cancelar: ");
		int id = sc.nextInt();
		
		System.out.println("Tem certeza que deseja remover cartão(1), cancelar(0)");
        int op = sc.nextInt();
        if (op == 1) {
        	for(int i = 0; i < cartoes.size(); i++) {
        		if(cartoes.get(i).getId() == id) {
        			cartoes.remove(i);
        			System.out.println("Cartão removido com sucesso");
        			break;
        		}
        		System.out.println("Cartão não encontrado");
        	}
        } else {
        	System.out.println("Operação cancelada");
        }
        
        sc.close();
	}
	
	public static void buscarCartao(ArrayList<CartaoFidelidade> cartoes, Scanner sc) {
		if(cartoes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado");
			return;
		}
		
		System.out.println("Digite o id do cartão: ");
		int id = sc.nextInt();
		for (int i = 0; i < cartoes.size(); i++) {
			int idCartao = cartoes.get(i).getId();

            if (id == idCartao) {
                cartoes.get(i).imprimirCartao(0);
                System.out.println();
            }
        }
	}
	
	public static void listarCartoes(ArrayList<CartaoFidelidade> cartoes) {
		if(cartoes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado");
			return;
		}
		System.out.println("LISTA DE PRODUTOS");

        for (int i = 0; i < cartoes.size(); i++) {
            cartoes.get(i).imprimirCartao(i);
            System.out.println();
        }
	}
}
