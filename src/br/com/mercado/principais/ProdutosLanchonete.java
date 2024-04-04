package br.com.mercado.principais;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutosLanchonete extends Produto {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ProdutosLanchonete(String nome, int quantidade, double precoUnitario, Date dataFabricacao) {
        super(nome, null, quantidade, precoUnitario, dataFabricacao, null);
    }
    
	@Override
	public double calcularDesconto() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
