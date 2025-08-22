package br.edu.infnet.eduardolimaapi.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Entity
public class Bebida extends Produto {

	
	private String tipo;

	private int codigo;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fornecedor_id")
	@Valid
	private Fornecedor fornecedor;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		return String.format(" - %s - %s - %d", super.toString(), tipo, codigo);
	}
	
}
