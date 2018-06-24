package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
