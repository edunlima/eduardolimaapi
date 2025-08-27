package br.edu.infnet.eduardolimaapi.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O nome é obrigatório.")
	private String nome;
	
	@Transient
	private String telefone;
	
	@NotBlank(message = "O email é necessario para contato eventual.")
	@Email(message = "O email é invalido.")
	private String email;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "fornecedor")
	@Valid
	private List<Bebida> listaBebidas = new ArrayList<>();
	
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Bebida> getListaBebidas() {
		return listaBebidas;
	}
	public void setListaBebidas(List<Bebida> listaBebidas) {
		this.listaBebidas = listaBebidas;
	}
	@Override
	public String toString()
	{
		return String.format(" - %s - %s - %s", nome, telefone, email);
	}
}
