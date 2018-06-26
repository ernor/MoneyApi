package br.com.api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Lancamento;
import br.com.api.model.Pessoa;
import br.com.api.repository.LancamentoRepository;
import br.com.api.repository.PessoaRepository;
import br.com.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento salvar(@Valid Lancamento lancamento) {
		
		Pessoa pessoa = null;
				
		try{
			pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).get();
		
		} catch(Exception e) {
			if(pessoa == null || pessoa.isInativo()) {
				throw new PessoaInexistenteOuInativaException();
			}
		}
			
		return lancamentoRepository.save(lancamento);
	}

}
