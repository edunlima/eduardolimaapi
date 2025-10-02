package br.infnet.edu.mono.model.services;

import br.infnet.edu.mono.clients.CocktailDBClient;
import br.infnet.edu.mono.dto.BebidaRequestDTO;
import br.infnet.edu.mono.dto.BebidaResponseDTO;
import br.infnet.edu.mono.model.domain.Bebida;
import br.infnet.edu.mono.model.repository.BebidaRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BebidaService {

	private final CocktailDBClient cocktailDBClient;
	private final BebidaRepository bebidaRepository;
	
	public BebidaService(CocktailDBClient cockTailDBClient, BebidaRepository bebidaRepository)
	{
		this.cocktailDBClient = cockTailDBClient;
		this.bebidaRepository = bebidaRepository;
	}
	
	//PRONTO
	private Bebida copyFromCocktailDBResponse(CocktailDBClient.CocktailDBResponse response)
	{
		
		List<CocktailDBClient.Drink> listaDrinks = response.getDrinks();
		CocktailDBClient.Drink drink = listaDrinks.get(0);
		Bebida bebida = new Bebida();
		bebida.setId(Integer.valueOf(drink.getIdDrink()));
		bebida.setNome(drink.getStrDrink());
		bebida.setCategoriaDrink(drink.getStrCategory());
		bebida.setSubCategoriaDrink(drink.getStrIBA());
		bebida.setTipoDeCopo(drink.getStrGlass());
		bebida.setInstrucoes(drink.getStrInstructions());
		bebida.setIngredientes(drink.todosIngredientes());
		bebida.setMedidasIngredientes(drink.todasMedidas());
		
		return bebida;
	}
	
	
	public BebidaResponseDTO incluir(BebidaRequestDTO bebidaRequestDTO)
	{
		
		bebidaRepository.findByNome(bebidaRequestDTO.getNome())
						.ifPresent( b -> { throw new ResponseStatusException(HttpStatus.CONFLICT, "Bebida já cadastrada.");} );
		
		Bebida bebida = new Bebida();
		bebida.setNome(bebidaRequestDTO.getNome());
		bebida.setPreco(bebidaRequestDTO.getPreco());
		bebida.setCategoriaDrink(bebidaRequestDTO.getCategoriaDrink());
		bebida.setTipoDeCopo(bebidaRequestDTO.getTipoDeCopo());
		bebida.setIngredientes(bebidaRequestDTO.getIngredientes());
		bebida.setMedidasIngredientes(bebidaRequestDTO.getMedidasIngredientes());
		bebida.setInstrucoes(bebidaRequestDTO.getInstrucoes());
		
		Bebida bebidaNova = bebidaRepository.save(bebida);
		
		return new BebidaResponseDTO(bebidaNova);
	}
	
	
	public BebidaResponseDTO consultarPorNome(String nome)
	{
		if(bebidaRepository.existsByNome(nome))
		{
			Bebida bebida = bebidaRepository.findByNome(nome)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bebida não encontrada."));
			return new BebidaResponseDTO(bebida);
		}
		
		CocktailDBClient.CocktailDBResponse response = cocktailDBClient.buscarDrinkPorNome(nome);
		
		if(response == null || response.isErro())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro na requisição do drink.");
		}
		
		Bebida bebida = copyFromCocktailDBResponse(response);
		
		return new BebidaResponseDTO(bebida);
	}
	
	public Bebida alterar(String nome, Bebida bebidaAtualizada)
	{
		
		Bebida bebidaExistente = bebidaRepository.findByNome(nome)
									.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bebida não encontrada."));
		
		if(!bebidaExistente.getNome().equals(bebidaAtualizada.getNome()))
		{
			bebidaRepository.findByNome(bebidaAtualizada.getNome())
							.ifPresent( b -> {throw new ResponseStatusException(HttpStatus.CONFLICT, "Esse nome já está cadastrado em outro drink.");});
		}
		
		bebidaExistente.setPreco(bebidaAtualizada.getPreco());
		bebidaExistente.setCategoriaDrink(bebidaAtualizada.getCategoriaDrink());
		bebidaExistente.setSubCategoriaDrink(bebidaAtualizada.getSubCategoriaDrink());
		bebidaExistente.setIngredientes(bebidaAtualizada.getIngredientes());
		bebidaExistente.setMedidasIngredientes(bebidaAtualizada.getMedidasIngredientes());
		bebidaExistente.setTipoDeCopo(bebidaAtualizada.getTipoDeCopo());
		
		return bebidaRepository.save(bebidaExistente);
	}
	
	//PRONTO
	public List<Bebida> buscarBebidas()
	{
		return bebidaRepository.findAll();
	}
	
	//PRONTO
	public void excluir(Integer id)
	{
		if(!bebidaRepository.existsById(id))
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bebida não existe.");
		}
		
		bebidaRepository.deleteById(id);
	}
	
	//PRONTO
	public void indisponivel(Integer id)
	{
		Bebida bebida = bebidaRepository.findById(id)
						.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bebida não encontrada."));
		
		bebida.setDisponivel(false);
		bebidaRepository.save(bebida);
		
	}
	
	//PRONTO
	public void disponivel(Integer id)
	{
		Bebida bebida = bebidaRepository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bebida não encontrada."));

		bebida.setDisponivel(true);
		bebidaRepository.save(bebida);
	}
	
}
