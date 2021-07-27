package br.com.foursalescontrol.core.app;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.foursalescontrol.core.domain.Candidato;

@Service
public interface CandidatoCrudService {
	
	public Candidato buscar(Long id) throws Exception;
	public List<Candidato> buscarTodos();
	public void incluir(Candidato candidato);
	public void atualizar(Candidato candidato) throws Exception;
	public void remover(Long id) throws Exception;

}
