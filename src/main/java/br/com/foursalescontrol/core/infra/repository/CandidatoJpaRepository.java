package br.com.foursalescontrol.core.infra.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.foursalescontrol.core.domain.Candidato;

public class CandidatoJpaRepository implements CandidatoRepositoryInterface {
	
	@Autowired
	private CandidatoRepository repository;

	@Override
	public Candidato buscar(Long id) {
		return this.repository.findById(id).orElseThrow();
	}
	
	@Override
	public List<Candidato> buscarTodos() {
		return this.repository.findAll();
	}
	
	@Override
	public void salvar(Candidato candidato) {
		this.repository.save(candidato);
	}

	@Override
	public void atualizar(Candidato candidato) {
		this.repository.save(candidato);
	}

	@Override
	public void deletar(Long id) {
		this.repository.deleteById(id);
	}

}
