package br.com.foursalescontrol.core.infra.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.foursalescontrol.core.domain.Candidato;
import br.com.foursalescontrol.core.infra.repository.model.CandidatoModel;
import lombok.RequiredArgsConstructor;

@Repository("candidatoJPA")
@RequiredArgsConstructor
public class CandidatoJpaRepository implements CandidatoRepositoryInterface {
	
	private final CandidatoRepository repository;

	@Override
	public Candidato buscar(Long id) {
		CandidatoModel candidatoModel = this.repository.findById(id).orElseThrow();
		return Candidato.builder()
						.id(candidatoModel.getId())
						.nome(candidatoModel.getNome())
						.cpf(candidatoModel.getCpf())
						.cartoes(candidatoModel.getCartoes())
						.build();
	}
	
	@Override
	public List<Candidato> buscarTodos() {
		List<CandidatoModel> listCandidatoModel = this.repository.findAll();
		return listCandidatoModel.stream().map(candidatoModel -> Candidato.builder()
																		  .id(candidatoModel.getId())
																		  .nome(candidatoModel.getNome())
																		  .cpf(candidatoModel.getCpf())
																		  .cartoes(candidatoModel.getCartoes())
																		  .build())
										  .collect(Collectors.toList());
	}
	
	@Override
	public void salvar(Candidato candidato) {
		this.repository.save(CandidatoModel.builder()
										   .id(candidato.getId())
										   .nome(candidato.getNome())
										   .cpf(candidato.getCpf())
										   .cartoes(candidato.getCartoes())
										   .build());
	}

	@Override
	public void atualizar(Candidato candidato) {
		salvar(candidato);
	}

	@Override
	public void deletar(Long id) {
		this.repository.deleteById(id);
	}

}
