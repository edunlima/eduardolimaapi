package br.edu.infnet.eduardolimaapi.model.exceptions;

public class FornecedorNaoEncontradoException extends RuntimeException {

	
	public FornecedorNaoEncontradoException(String mensagem)
	{
		super(mensagem);
	}
}
