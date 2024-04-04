package br.com.mercado.principais;

import br.com.mercado.cliente.Pessoa;

public class CartaoFidelidade implements Desconto {
	
	private Pessoa cliente;
	private int id;
	private int senha;
	private int comprasFeitas;
	
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
