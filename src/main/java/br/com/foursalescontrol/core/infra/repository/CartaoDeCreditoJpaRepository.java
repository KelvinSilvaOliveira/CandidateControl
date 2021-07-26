package br.com.foursalescontrol.core.infra.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.foursalescontrol.core.domain.CartaoDeCredito;
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
								   cartaoModel.getDataValidade());
	}
	
	@Override
	public List<CartaoDeCredito> buscarTodos() {
		List<CartaoModel> listCartaoModel = this.repository.findAll();
		return listCartaoModel.stream().map(cartaoModel -> {return new CartaoDeCredito(cartaoModel.getId(), 
																					   cartaoModel.getNumero(), 
																					   cartaoModel.getNomeImpresso(), 
																					   cartaoModel.getCvv(), 
																					   cartaoModel.getDataValidade());})
									   .collect(Collectors.toList());
	}
	
	@Override
	public void salvar(CartaoDeCredito cartao) {
		this.repository.save(CartaoModel.builder()
										.id(cartao.getId())
										.nomeImpresso(cartao.getNomeImpresso())
										.numero(cartao.getNumero())
										.cvv(cartao.getCvv())
										.dataValidade(cartao.getDataValidade())
										.build());
	}

	@Override
	public void atualizar(CartaoDeCredito cartao) {
		salvar(cartao);
	}

	@Override
	public void deletar(Long id) {
		this.repository.deleteById(id);
	}

}
