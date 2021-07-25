package br.com.foursalescontrol.core.app;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.foursalescontrol.core.domain.Candidato;
import br.com.foursalescontrol.core.infra.repository.CandidatoRepositoryInterface;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidatoCrudImpl implements CandidatoCrudService {
	
	private final CandidatoRepositoryInterface repository;

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
