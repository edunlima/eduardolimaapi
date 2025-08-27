package br.edu.infnet.eduardolimaapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.eduardolimaapi.model.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
