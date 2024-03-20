package br.com.mercado.principais;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class Produtos implements Desconto {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String nome;
    private String lote;
    private int quantidade;
    private double precoUnitario;
    private double precoTotal;
    private Date dataFabricacao;
    private Date dataVencimento;
    private int diasParaVencer;
    private double valorFinal;

    public Produtos(String nome, String lote, int quantidade, double precoUnitario, Date dataFabricacao,
            Date dataVencimento) {
        this.nome = nome;
        this.lote = lote;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = quantidade * precoUnitario;
        this.dataFabricacao = dataFabricacao;
        this.dataVencimento = dataVencimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.precoTotal = quantidade * precoUnitario;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
        this.precoTotal = quantidade * precoUnitario;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public double getValorFinal() {
        return valorFinal;
    }
}