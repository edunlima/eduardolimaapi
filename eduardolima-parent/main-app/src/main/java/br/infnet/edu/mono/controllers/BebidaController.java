package br.infnet.edu.mono.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.infnet.edu.mono.dto.BebidaRequestDTO;
import br.infnet.edu.mono.dto.BebidaResponseDTO;
import br.infnet.edu.mono.model.domain.Bebida;
import br.infnet.edu.mono.model.services.BebidaService;
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
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public List<Bebida> obterLista()
	{
		return bebidaService.buscarBebidas();
	}
	
	@GetMapping(value = "/{nome}")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public ResponseEntity<BebidaResponseDTO> consultarPorNome(@PathVariable("nome") String nome)
	{
		return ResponseEntity.ok(bebidaService.consultarPorNome(nome));
	}
	
	@PostMapping("/incluir")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<BebidaResponseDTO> incluir(@Valid @RequestBody BebidaRequestDTO bebidaRequestDTO)
	{
		BebidaResponseDTO novaBebida = bebidaService.incluir(bebidaRequestDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novaBebida);
	}
	
	
	@PutMapping(value = "/alterar/{nome}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Bebida> alterar(@PathVariable String nome, @Valid @RequestBody Bebida bebida)
	{
		return ResponseEntity.ok(bebidaService.alterar(nome, bebida));
	}
	
	@PatchMapping(value = "/disponibilizar/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> disponibilizar(@PathVariable Integer id)
	{
		bebidaService.disponivel(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping(value = "/indisponibilizar/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> indisponibilizar(@PathVariable Integer id)
	{
		bebidaService.indisponivel(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/excluir/{id}")
	//@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> excluir(@PathVariable Integer id)
	{
		bebidaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
