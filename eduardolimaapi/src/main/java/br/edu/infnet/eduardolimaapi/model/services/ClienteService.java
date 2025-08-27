package br.edu.infnet.eduardolimaapi.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.eduardolimaapi.model.domain.Cliente;
import br.edu.infnet.eduardolimaapi.model.repository.ClienteRepository;

@Service
public class ClienteService implements CrudService<Cliente, Integer>{

	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository)
	{
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public Cliente alterar(Integer id, Cliente entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente incluir(Cliente vendedor) {
		
		return clienteRepository.save(vendedor);
	}

	@Override
	public Cliente buscarPorId(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Integer Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> obterLista() {
		// TODO Auto-generated method stub
		return null;
	}

}

	
	
	
	

