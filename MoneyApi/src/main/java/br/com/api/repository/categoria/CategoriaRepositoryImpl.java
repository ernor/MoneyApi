package br.com.api.repository.categoria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.com.api.model.Categoria;
import br.com.api.model.Categoria_;
import br.com.api.repository.filter.CategoriaFilter;

public class CategoriaRepositoryImpl implements CategoriaRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Categoria> filtrar(CategoriaFilter categoriaFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
		
		Root<Categoria> root = criteria.from(Categoria.class);
		
		Predicate[] predicates = criarRestricoes(categoriaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Categoria> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(CategoriaFilter categoriaFilter, CriteriaBuilder builder, Root<Categoria> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(categoriaFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get(Categoria_.nome)), "%" + categoriaFilter.getNome().toLowerCase() + "%"));
		}
			
		return  predicates.toArray(new Predicate[predicates.size()]);	
	}

}
