package br.com.foursalescontrol.core.infra.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.foursalescontrol.core.domain.Candidato;
import br.com.foursalescontrol.core.domain.CartaoDeCredito;
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
						.cartoes(null)
						.build();
	}
	
	@Override
	public List<Candidato> buscarTodos() {
		List<CandidatoModel> listCandidatoModel = this.repository.findAll();
		return listCandidatoModel.stream().map(candidatoModel -> Candidato.builder()
																		  .id(candidatoModel.getId())
																		  .nome(candidatoModel.getNome())
																		  .cpf(candidatoModel.getCpf())
																		  .cartoes(candidatoModel.getCartoes().stream()
																				  							  .map(cartaoModel -> {return new CartaoDeCredito(cartaoModel.getId(), 
																																							  cartaoModel.getNumero(), 
																																							  cartaoModel.getNomeImpresso(), 
																																							  cartaoModel.getCvv(), 
																																							  cartaoModel.getDataValidade(),
																																							  null);})
																				  							  .collect(Collectors.toList()))
																		  .build())
										  .collect(Collectors.toList());
	}
	
	@Override
	public Candidato salvar(Candidato candidato) {
		CandidatoModel candidatoModel = this.repository.save(CandidatoModel.builder()
																		   .id(candidato.getId())
																		   .nome(candidato.getNome())
																		   .cpf(candidato.getCpf())
																		   .cartoes(null)
																		   .build());
		return Candidato.builder().id(candidatoModel.getId())
								  .nome(candidatoModel.getNome())
								  .cpf(candidatoModel.getCpf())
								  .cartoes(null)
								  .build();
	}

	@Override
	public Candidato atualizar(Candidato candidato) {
		return salvar(candidato);
	}

	@Override
	public void deletar(Long id) {
		this.repository.deleteById(id);
	}

}
