package br.com.foursalescontrol.core.infra.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.foursalescontrol.core.domain.Candidato;
import br.com.foursalescontrol.core.domain.CartaoDeCredito;
import br.com.foursalescontrol.core.infra.repository.model.CandidatoModel;
import br.com.foursalescontrol.core.infra.repository.model.CartaoModel;
import lombok.RequiredArgsConstructor;

@Repository("cartaoCreditoJPA")
@RequiredArgsConstructor
public class CartaoDeCreditoJpaRepository implements CartaoRepositoryInterface {
	
	private final CartaoRepository repository;

	@Override
	public CartaoDeCredito buscar(Long id) {
		CartaoModel cartaoModel = this.repository.findById(id).orElseThrow();
		return new CartaoDeCredito(cartaoModel.getId(), 
								   cartaoModel.getNumero(), 
								   cartaoModel.getNomeImpresso(), 
								   cartaoModel.getCvv(), 
								   cartaoModel.getDataValidade(),
								   Candidato.builder().id(cartaoModel.getCandidato().getId())
								   					  .nome(cartaoModel.getCandidato().getNome())
								   					  .cpf(cartaoModel.getCandidato().getCpf())
								   					  .build());
	}
	
	@Override
	public List<CartaoDeCredito> buscarTodos() {
		List<CartaoModel> listCartaoModel = this.repository.findAll();
		return listCartaoModel.stream().map(cartaoModel -> {return new CartaoDeCredito(cartaoModel.getId(), 
																					   cartaoModel.getNumero(), 
																					   cartaoModel.getNomeImpresso(), 
																					   cartaoModel.getCvv(), 
																					   cartaoModel.getDataValidade(),
																					   Candidato.builder().id(cartaoModel.getCandidato().getId())
																					   					  .nome(cartaoModel.getCandidato().getNome())
																					   					  .cpf(cartaoModel.getCandidato().getCpf())
																					   					  .build());})
									   .collect(Collectors.toList());
	}
	
	@Override
	public CartaoDeCredito salvar(CartaoDeCredito cartao) {
		CartaoModel cartaoModel = this.repository.save(CartaoModel.builder()
																  .id(cartao.getId())
																  .nomeImpresso(cartao.getNomeImpresso())
																  .numero(cartao.getNumero())
																  .cvv(cartao.getCvv())
																  .dataValidade(cartao.getDataValidade())
																  .candidato(CandidatoModel.builder().id(cartao.getCandidato().getId()).build())
																  .build());
		return new CartaoDeCredito(cartaoModel.getId(), cartaoModel.getNumero(), cartaoModel.getNomeImpresso(), cartaoModel.getCvv(), cartaoModel.getDataValidade(), null);
	}

//	@Override
//	public CartaoDeCredito atualizar(CartaoDeCredito cartao) {
//		return salvar(cartao);
//	}

	@Override
	public void deletar(Long id) {
		this.repository.deleteById(id);
	}

}
