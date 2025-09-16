package br.edu.infnet.eduardolimatesteapi.model.domain;

import java.math.BigDecimal;

public class Item {

	
	private String nome;
	private BigDecimal preco;
	
	public Item(String nome, BigDecimal preco)
	{
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	

	
}
