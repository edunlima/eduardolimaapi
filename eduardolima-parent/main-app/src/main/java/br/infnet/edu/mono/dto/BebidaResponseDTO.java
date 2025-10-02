package br.infnet.edu.mono.dto;

import java.util.List;

import br.infnet.edu.mono.model.domain.Bebida;

public class BebidaResponseDTO {

	private String id;
	private String nome;
	private double preco;
	private String categoriaDrink;
	private String tipoDeCopo;
	private List<String> ingredientes;
	private List<String> medidasIngredientes;
	private String instrucoes;
	
	public BebidaResponseDTO(Bebida bebida)
	{
		this.setId(bebida.getId().toString());
		this.setNome(bebida.getNome());
		this.setPreco(bebida.getPreco());
		this.setCategoriaDrink(bebida.getCategoriaDrink());
		this.setTipoDeCopo(bebida.getTipoDeCopo());
		this.setIngredientes(bebida.getIngredientes());
		this.setMedidasIngredientes(bebida.getMedidasIngredientes());
		this.setInstrucoes(bebida.getInstrucoes());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCategoriaDrink() {
		return categoriaDrink;
	}

	public void setCategoriaDrink(String categoriaDrink) {
		this.categoriaDrink = categoriaDrink;
	}

	public String getTipoDeCopo() {
		return tipoDeCopo;
	}

	public void setTipoDeCopo(String tipoDeCopo) {
		this.tipoDeCopo = tipoDeCopo;
	}

	public List<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<String> getMedidasIngredientes() {
		return medidasIngredientes;
	}

	public void setMedidasIngredientes(List<String> medidasIngredientes) {
		this.medidasIngredientes = medidasIngredientes;
	}

	public String getInstrucoes() {
		return instrucoes;
	}

	public void setInstrucoes(String instrucoes) {
		this.instrucoes = instrucoes;
	}
	
	
}
