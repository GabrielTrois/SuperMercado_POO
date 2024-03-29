package br.com.mercado.principais;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoNaoPerecivel extends Produto implements Desconto {
	
    public ProdutoNaoPerecivel(String nome, String lote, int quantidade, double precoUnitario, Date dataFabricacao) {
        super(nome, lote, quantidade, precoUnitario, dataFabricacao, null);
    }

    @Override
    public int calcularVencimento() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        long diferenca = getDataVencimento().getTime() - hoje.getTime();
        long dias = diferenca / (1000 * 60 * 60 * 24);
        return (int) dias;
    }
    
    @Override
    public double calcularDesconto() {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        long diferenca = hoje.getTime() - getDataFabricacao().getTime();
        long dias = diferenca / (1000 * 60 * 60 * 24);

        double desconto;
        
        if(dias > 90 && dias < 120) {
        	desconto = getPrecoUnitario() * 0.3;
        } 
        else if(dias >= 120) {
        	desconto = getPrecoUnitario() * 0.65;
        } else {
        	desconto = 0.0;
        }
        
    	return getPrecoUnitario() - desconto;
    }
}