package br.infnet.edu.mono.model.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Bebida extends Produto {

	@Column
	private String categoriaDrink;
	
	@Column
	private String subCategoriaDrink;
	
	@Column
	private String tipoDeCopo;
	
	@Column
	private List<String> ingredientes;
	
	@Column
	private List<String> medidasIngredientes;
	
	@Column
	private String instrucoes;

	
	public String getCategoriaDrink() {
		return categoriaDrink;
	}
	public void setCategoriaDrink(String categoriaDrink) {
		this.categoriaDrink = categoriaDrink;
	}
	public String getSubCategoriaDrink() {
		return subCategoriaDrink;
	}
	public void setSubCategoriaDrink(String subCategoriaDrink) {
		this.subCategoriaDrink = subCategoriaDrink;
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
