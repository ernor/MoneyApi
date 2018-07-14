package br.com.api.repository.lancamento;

import java.util.List;

import br.com.api.model.Lancamento;
import br.com.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);

}
