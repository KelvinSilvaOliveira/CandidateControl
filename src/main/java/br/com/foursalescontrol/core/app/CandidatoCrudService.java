package br.com.foursalescontrol.core.app;

import java.util.List;

import br.com.foursalescontrol.core.domain.Candidato;

public interface CandidatoCrudService {
	
	public Candidato buscar(Long id);
	public List<Candidato> buscarTodos();
	public void incluir(Candidato candidato);
	public void atualizar(Candidato candidato);
	public void deletar(Long id);

}
