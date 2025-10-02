package br.infnet.edu.mono.dto;

import java.util.List;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BebidaRequestDTO {

	
	@NotBlank(message = "O nome precisa ser especificado.")
	@Size(min = 3 ,max = 50)
	private String nome;
	
	@NotNull(message = "O preço não pode ser vazio.")
	private double preco;
	
	@NotBlank(message = "A categoria do drink precisa ser especificada.")
	private String categoriaDrink;
	
	@Transient
	private String subCategoriaDrink;
	
	@NotBlank(message = "O tipo de copo do drink precisa ser especificado.")
	private String tipoDeCopo;
	
	@NotEmpty(message = "Os ingredientes do drink precisam ser mencionados.")
	private List<String> ingredientes;
	
	@NotEmpty(message = "As medidas dos ingredientes precisam ser mencionados.")
	private List<String> medidasIngredientes;
	
	@NotBlank(message = "É necessario explicar como é feito o drink.")
	private String instrucoes;

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

	public void setInstrucoes(String intrucoes) {
		this.instrucoes = intrucoes;
	}

	public String getSubCategoriaDrink() {
		return subCategoriaDrink;
	}

	public void setSubCategoriaDrink(String subCategoriaDrink) {
		this.subCategoriaDrink = subCategoriaDrink;
	}
	
	
	
	
	
	
}
