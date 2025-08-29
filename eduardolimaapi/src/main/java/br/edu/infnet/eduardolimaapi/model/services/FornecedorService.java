package br.edu.infnet.eduardolimaapi.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.eduardolimaapi.model.domain.Fornecedor;
import br.edu.infnet.eduardolimaapi.model.exceptions.FornecedorNaoEncontradoException;
import br.edu.infnet.eduardolimaapi.model.repository.FornecedorRepository;
import jakarta.transaction.Transactional;

@Service
public class FornecedorService implements CrudService<Fornecedor, Integer>{

	private final FornecedorRepository fornecedorRepository;
	
	public FornecedorService(FornecedorRepository fornecedorRepository)
	{
		this.fornecedorRepository = fornecedorRepository;
	}
	
	@Override
	public Fornecedor alterar(Integer id, Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Fornecedor incluir(Fornecedor fornecedor) {
		
		return fornecedorRepository.save(fornecedor);
	}

	@Override
	public Fornecedor buscarPorId(Integer Id) {
		// TODO Auto-generated method stub
		return fornecedorRepository.findById(Id).orElseThrow(() -> new FornecedorNaoEncontradoException("Fornecedor não foi encontrado!"));
	}

	@Override
	public void excluir(Integer Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fornecedor> obterLista() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Fornecedor obterPorCodigo(Integer codigo)
	{
		return fornecedorRepository.findByCodigo(codigo).orElseThrow(() -> new FornecedorNaoEncontradoException("Fornecedor não foi encontrado!"));
	}
	
	public Fornecedor obterPorNome(String nome)
	{
		return fornecedorRepository.findByNome(nome);
	}

}

	
	
	
	

