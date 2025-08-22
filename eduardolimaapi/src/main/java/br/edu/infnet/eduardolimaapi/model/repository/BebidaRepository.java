package br.edu.infnet.eduardolimaapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.eduardolimaapi.model.domain.Bebida;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Integer>{

}
