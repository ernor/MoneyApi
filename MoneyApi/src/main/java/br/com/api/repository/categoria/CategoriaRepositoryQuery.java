package br.com.api.repository.categoria;

import java.util.List;

import br.com.api.model.Categoria;
import br.com.api.repository.filter.CategoriaFilter;

public interface CategoriaRepositoryQuery {
	
	public List<Categoria> filtrar(CategoriaFilter categoriaFilter);

}
