package br.com.foursalescontrol.core.infra.repository;

import java.util.List;

import br.com.foursalescontrol.core.domain.Candidato;

public interface CandidatoRepositoryInterface {

	void salvar(Candidato Candidato);
	Candidato buscar(Long id);
	List<Candidato> buscarTodos();
	void atualizar(Candidato Candidato);
	void deletar(Long id);
	
}
