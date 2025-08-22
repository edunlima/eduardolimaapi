package br.edu.infnet.eduardolimaapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.eduardolimaapi.model.domain.Bebida;
import br.edu.infnet.eduardolimaapi.model.services.BebidaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {
	
	private final BebidaService bebidaService;
	
	public BebidaController(BebidaService bebidaService)
	{
		this.bebidaService = bebidaService;
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<Bebida>> obterListaBebidas()
	{
		List<Bebida> listaBebidas = bebidaService.obterLista();
		
		if(listaBebidas.isEmpty()) return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(listaBebidas); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bebida> obterBebidaPorId(@PathVariable Integer id)
	{
		
		Bebida bebida = bebidaService.buscarPorId(id);
	
		return ResponseEntity.ok(bebida); 
	}
	
	//POST para inclusões  
	@PostMapping
	public ResponseEntity<Bebida> incluirBebida(@Valid @RequestBody Bebida bebida)
	{
		
		Bebida novaBebida = bebidaService.incluir(bebida);
		
		return ResponseEntity.ok(novaBebida);
	}
	
	//PUT para alterações consideraveis
	@PutMapping(value = "/{id}")
	public ResponseEntity<Bebida> alterarBebida(@PathVariable Integer id, @RequestBody Bebida bebida)
	{
		
		Bebida bebidaAlterada = bebidaService.alterar(id, bebida);
		
		return ResponseEntity.ok(bebidaAlterada);
				
		
	}
	
	//PATCH para alterações parciais
	@PatchMapping(value = "/{id}/indisponibilizar")
	public ResponseEntity<Bebida> inativarBebida(@PathVariable Integer id)
	{
		
		Bebida bebidaIndisponivel = bebidaService.indisponibilizar(id);
		
		return ResponseEntity.ok(bebidaIndisponivel);
				
		
	}
	
	//DELETE para deletar 
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirBebida(@PathVariable Integer id)
	{
		bebidaService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}
