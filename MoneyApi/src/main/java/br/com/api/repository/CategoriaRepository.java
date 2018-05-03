package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
