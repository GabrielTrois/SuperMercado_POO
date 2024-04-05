package br.com.mercado.repositorio;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.mercado.cliente.Pessoa;
import br.com.mercado.principais.CartaoFidelidade;

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
	
	public static void cancelarCartao(ArrayList<CartaoFidelidade> cartoes, int id) {
		Scanner sc = new Scanner(System.in);
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
}
