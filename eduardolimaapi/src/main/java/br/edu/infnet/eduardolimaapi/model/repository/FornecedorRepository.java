package br.edu.infnet.eduardolimaapi.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.eduardolimaapi.model.domain.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Integer>{

	Optional<Fornecedor> findByCodigo(Integer codigo);
	Fornecedor findByNome(String nome);
	
}
