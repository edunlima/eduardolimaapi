package br.infnet.edu.mono.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.infnet.edu.mono.model.domain.Bebida;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Integer>{

	Optional<Bebida> findByNome(String nome);
	boolean existsByNome(String nome);
}
