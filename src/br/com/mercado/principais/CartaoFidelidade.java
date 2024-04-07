package br.com.mercado.principais;

import br.com.mercado.cliente.Pessoa;

public class CartaoFidelidade implements Desconto {
	
	private Pessoa cliente;
	private int id;
	private int senha;
	private int comprasFeitas;
	
	public CartaoFidelidade(Pessoa p, int id, int senha, int compras) {
		this.cliente = p;
		this.id = id;
		this.senha = senha;
		this.comprasFeitas = compras;
	}
	
	@Override
	public double calcularDesconto() {
		if(this.comprasFeitas > 10) {
			return 0.01;
		}
		else if(this.comprasFeitas > 50) {
			return 0.05;
		}
		else if(this.comprasFeitas > 100) {
			return 0.1;
		} else {
			return 0;
		}
	}

	public void imprimirCartao(int index) {
		System.out.println("+-----------------------------+");
		System.out.println("Index: " + index);
		System.out.println("Cliente: " + this.cliente.getNome());
		System.out.println("Cpf: " + this.cliente.getCpf());
		System.out.println("Idade: " + this.cliente.getIdade());
		System.out.println("Id do cartão: " + this.id);
		System.out.println("Compras feitas: " + this.comprasFeitas);
		System.out.println("+-----------------------------+");
	}
	
	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public int getComprasFeitas() {
		return comprasFeitas;
	}

	public void setComprasFeitas(int comprasFeitas) {
		this.comprasFeitas = comprasFeitas;
	}
}
