package br.edu.infnet.eduardolimaapi.model.exceptions;

public class BebidaNaoEncontradaException extends RuntimeException {

	public BebidaNaoEncontradaException(String mensagem)
	{
		super(mensagem);
	}
}
