package br.com.mercado.principais;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoPerecivel extends Produto {
	
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
}
