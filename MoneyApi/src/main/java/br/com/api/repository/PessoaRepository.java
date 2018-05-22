package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
