package br.edu.infnet.eduardolimaapi.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
	
	@NotNull(message = "É necessario um codigo de identificação.")
	@Digits(integer = 4, fraction = 0, message = "O codigo deve ter 4 numeros.")
	private Integer codigo;
	
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Bebida> bebidas = new ArrayList<Bebida>();
	
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
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public List<Bebida> getListaBebidas() {
		return bebidas;
	}
	public void setListaBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	@Override
	public String toString()
	{
		return String.format(" - %s - %s - %s", nome, telefone, email);
	}
}
