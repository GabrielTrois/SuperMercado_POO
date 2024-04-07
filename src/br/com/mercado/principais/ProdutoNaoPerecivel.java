package br.com.mercado.principais;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoNaoPerecivel extends Produto {
	
    public ProdutoNaoPerecivel(String nome, String lote, int quantidade, double precoUnitario, Date dataFabricacao) {
        super(nome, lote, quantidade, precoUnitario, dataFabricacao, dataFabricacao);
    }

    @SuppressWarnings("null")
	@Override
    public int calcularVencimento() {
        return 0;
    }
    
    @Override
    public double calcularDesconto() {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        long diferenca = hoje.getTime() - super.getDataFabricacao().getTime();
        long dias = diferenca / (1000 * 60 * 60 * 24);

        double desconto;
        
        if(dias > 365 && dias < 2*365) {
        	desconto = super.getPrecoUnitario() * 0.1;
        } 
        else if(dias >= 2*365) {
        	desconto = super.getPrecoUnitario() * 0.15;
        } else {
        	desconto = 0.0;
        }
        
    	return super.getPrecoUnitario() - desconto;
    }
}