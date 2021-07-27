package br.com.foursalescontrol.core.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.foursalescontrol.core.domain.Candidato;
import br.com.foursalescontrol.core.infra.repository.CandidatoRepositoryInterface;

@Service
public class CandidatoCrudImpl implements CandidatoCrudService {
	
	
	private CandidatoRepositoryInterface repository;
	
	public CandidatoCrudImpl(@Qualifier("candidatoJPA") CandidatoRepositoryInterface repository) {
		this.repository = repository;
	}

	@Override
	public Candidato buscar(Long id) throws Exception {
		if(id == 0) 
			throw new Exception("Candidato não pode ser 0");
		return this.repository.buscar(id);
	}
	
	@Override
	public List<Candidato> buscarTodos() {
		return this.repository.buscarTodos();
	}

	@Override
	public Candidato incluir(Candidato candidato) {
		candidato.setId(null);
		return this.repository.salvar(candidato);
	}

	@Override
	public Candidato atualizar(Candidato candidato) throws Exception {
		if(Optional.of(this.repository.buscar(candidato.getId())).isEmpty()) 
			throw new Exception("Candidato não encontrado");
		return this.repository.atualizar(candidato);
	}

	@Override
	public void remover(Long id) throws Exception {
		if(id == 0) 
			throw new Exception("Candidato não pode ser 0");
		this.repository.deletar(id);
	}

}
