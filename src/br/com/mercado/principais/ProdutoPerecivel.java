package br.com.mercado.principais;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoPerecivel extends Produto implements Desconto {
	
    public ProdutoPerecivel(String nome, String lote, int quantidade, double precoUnitario, Date dataFabricacao,
            Date dataVencimento) {
        super(nome, lote, quantidade, precoUnitario, dataFabricacao, dataVencimento);
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
        long diferenca = getDataVencimento().getTime() - hoje.getTime();
        long dias = diferenca / (1000 * 60 * 60 * 24);

        double desconto;

        if (dias <= 30 && dias >= 15) {
            desconto = getPrecoUnitario() * 0.3;
        } 
        else if (dias < 15 && dias > 0) {
            desconto = getPrecoUnitario() * 0.65;
        } else {
            desconto = 0.0;
        }

        return getPrecoUnitario() - desconto;
    }
}
