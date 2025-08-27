package br.edu.infnet.eduardolimaapi.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import br.edu.infnet.eduardolimaapi.model.domain.Bebida;
import br.edu.infnet.eduardolimaapi.model.exceptions.BebidaInvalidaException;
import br.edu.infnet.eduardolimaapi.model.exceptions.BebidaNaoEncontradaException;
import br.edu.infnet.eduardolimaapi.model.repository.BebidaRepository;
import jakarta.transaction.Transactional;

@Service
public class BebidaService implements CrudService<Bebida, Integer> {
	
	private final BebidaRepository bebidaRepository;
	
	public BebidaService(BebidaRepository bebidaRepository)
	{
		this.bebidaRepository = bebidaRepository;
	}
	
	private void validarBebida(Bebida bebida)
	{
		if(bebida == null) throw new IllegalArgumentException("A bebida não pode ser nula!");
		if(bebida.getNome() == null || bebida.getNome().trim().isEmpty()) throw new BebidaInvalidaException("A bebida precisa ter nome!");
	}

	private void validarId(Integer id)
	{
		if(id == null || id <= 0) throw new IllegalArgumentException("Esse ID não é aceito.");
		
	}
	
	
	@Override
	@Transactional
	public Bebida alterar(Integer id, Bebida bebida) {
		
		validarId(id);
		validarBebida(bebida);
		
		bebida.setId(id);
		bebidaRepository.save(bebida);
		return bebida;
		
	}

	@Override
	@Transactional
	public Bebida incluir(Bebida bebida) {
		
		validarBebida(bebida);
		
		return bebidaRepository.save(bebida);
	}


	@Override
	@Transactional
	public void excluir(Integer id) {
		
		validarId(id);
		
		bebidaRepository.deleteById(id);
	}
	
	@Transactional
	public Bebida indisponibilizar(Integer id) {
		
		validarId(id);
		
		Bebida bebida = buscarPorId(id);
		if(!bebida.isDisponivel())
		{
			System.out.println("Bebida " + bebida.getNome() + " já está indisponivel!");
			return bebida;
		}
		
		bebida.setDisponivel(false);
		
		return bebidaRepository.save(bebida);
	}
	

	@Override
	public List<Bebida> obterLista() {
		// TODO Auto-generated method stub
		
		return bebidaRepository.findAll();
				
	}
	
	@Override
	public Bebida buscarPorId(Integer id) {
		
		validarId(id);
		
		Bebida bebida = bebidaRepository.findById(id).orElseThrow(() -> new BebidaNaoEncontradaException("alguma coisa ai pai"));  
		return bebida;
	}


	
	
}
