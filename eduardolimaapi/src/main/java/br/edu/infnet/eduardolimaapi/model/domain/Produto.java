package br.edu.infnet.eduardolimaapi.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O nome precisa ser especificado.")
	@Size(min = 3 ,max = 50)
	private String nome;
	
	@NotNull(message = "O preço não pode ser vazio.")
	private double preco;
	
	@NotNull(message = "É necessário indicar se está disponivel.")
	private boolean disponivel;
	
	@NotNull(message = "É necessário indicar se está dentro da validade.")
	private boolean dentroDaValidade;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fornecedor_id")
	@Valid
	private Fornecedor fornecedor;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public boolean isDentroDaValidade() {
		return dentroDaValidade;
	}
	public void setDentroDaValidade(boolean dentroDaValidade) {
		this.dentroDaValidade = dentroDaValidade;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	@Override
	public String toString()
	{
		return String.format("%d - %s - %.2f - %s - %s", id, nome, preco, disponivel ? "Disponivel" : "Indisponivel", 
								dentroDaValidade ? "Valido" : "Invalido" );
	}
	
}
