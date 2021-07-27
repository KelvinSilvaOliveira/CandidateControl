package br.com.foursalescontrol.core.infra.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.foursalescontrol.core.domain.Candidato;

@Repository
public interface CandidatoRepositoryInterface {

	Candidato buscar(Long id);
	List<Candidato> buscarTodos();
	Candidato salvar(Candidato Candidato);
	Candidato atualizar(Candidato Candidato);
	void deletar(Long id);
	
}
