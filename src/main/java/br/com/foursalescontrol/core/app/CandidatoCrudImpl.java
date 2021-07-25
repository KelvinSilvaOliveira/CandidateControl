package br.com.foursalescontrol.core.app;

import java.util.List;

import br.com.foursalescontrol.core.domain.Candidato;
import br.com.foursalescontrol.core.infra.repository.CandidatoRepositoryInterface;

public class CandidatoCrudImpl implements CandidatoCrudService {
	
	private CandidatoRepositoryInterface repository;
	
	public CandidatoCrudImpl(CandidatoRepositoryInterface repository) {
		this.repository = repository;
	}

	@Override
	public Candidato buscar(Long id) {
		return (Candidato) this.repository.buscar(id);
	}
	
	@Override
	public List<Candidato> buscarTodos() {
		return this.repository.buscarTodos();
	}

	@Override
	public void incluir(Candidato candidato) {
		this.repository.salvar(candidato);
	}

	@Override
	public void atualizar(Candidato candidato) {
		this.repository.atualizar(candidato);
	}

	@Override
	public void deletar(Long id) {
		this.repository.deletar(id);
	}

}
