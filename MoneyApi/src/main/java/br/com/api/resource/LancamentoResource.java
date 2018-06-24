package br.com.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Lancamento;
import br.com.api.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@GetMapping		
	public ResponseEntity<?> listar() {
		List<Lancamento> lancamentos = lancamentoRepository.findAll();
		return !lancamentos.isEmpty() ? ResponseEntity.ok(lancamentos) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo) {
		Lancamento lancamento = null;
		try {
			lancamento = lancamentoRepository.findById(codigo).get();
		} catch(Exception e) {
		}
		return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}

}
