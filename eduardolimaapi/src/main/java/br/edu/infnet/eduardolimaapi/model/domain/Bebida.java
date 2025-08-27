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

	@Transient
	private String tipo;

	@Transient
	private int codigo;
	
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
	
	@Override
	public String toString()
	{
		return String.format(" - %s - %s - %d", super.toString(), tipo, codigo);
	}
	
}
