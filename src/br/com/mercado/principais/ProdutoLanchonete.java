package br.com.mercado.principais;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoLanchonete extends Produto {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ProdutoLanchonete(String nome, int quantidade, double precoUnitario, Date dataFabricacao, Date dataVencimento) {
        super(nome, null, quantidade, precoUnitario, dataFabricacao, dataVencimento);
    }
    
	@Override
	public double calcularDesconto() {
		return super.getPrecoUnitario();
	}
    
}
