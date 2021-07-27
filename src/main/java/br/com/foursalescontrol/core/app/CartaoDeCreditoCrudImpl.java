package br.com.foursalescontrol.core.app;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.foursalescontrol.core.domain.Candidato;
import br.com.foursalescontrol.core.domain.CartaoDeCredito;
import br.com.foursalescontrol.core.infra.repository.CandidatoRepositoryInterface;
import br.com.foursalescontrol.core.infra.repository.CartaoRepositoryInterface;

@Service
public class CartaoDeCreditoCrudImpl implements CartaoDeCreditoCrudService {
	
	private CartaoRepositoryInterface repository;
	private CandidatoRepositoryInterface candidatoRepository;
	private PreparaDadosCartao dadosCartao;
	
	public CartaoDeCreditoCrudImpl(@Qualifier("cartaoCreditoJPA") CartaoRepositoryInterface repository,
								   @Qualifier("candidatoJPA") CandidatoRepositoryInterface candidatoRepository, 
								   @Qualifier("preparaCartaoDeCredito") PreparaDadosCartao dadosCartao) {
		this.repository = repository;
		this.candidatoRepository = candidatoRepository;
		this.dadosCartao = dadosCartao;
	}

	@Override
	public CartaoDeCredito buscar(Long id) throws Exception {
		if(id == 0) 
			throw new Exception("Cartão não pode ser 0");
		return this.repository.buscar(id);
	}
	
	@Override
	public List<CartaoDeCredito> buscarTodos() {
		return this.repository.buscarTodos();
	}

	@Override
	public CartaoDeCredito incluir(CartaoDeCredito cartao, Random randomico) throws Exception {
		if(cartao.getCandidato() == null || cartao.getCandidato().getId() == null || cartao.getCandidato().getId() == 0) 
			throw new Exception("Candidato deve ser informado e não pode ser 0");
		
		Candidato candidato = this.candidatoRepository.buscar(cartao.getCandidato().getId());
		
		cartao.setId(null);
		cartao.setNomeImpresso(this.dadosCartao.montaNomeImpresso(candidato.getNome()));
		cartao.setNumero(this.dadosCartao.geraNumero(randomico));
		cartao.setCvv(this.dadosCartao.geraCVV(randomico));
		cartao.setDataValidade(this.dadosCartao.defineDataValidade());
		
		return this.repository.salvar(cartao);
	}

//	@Override
//	public CartaoDeCredito atualizar(CartaoDeCredito cartao) throws Exception {
//		if(Optional.of(this.repository.buscar(cartao.getId())).isEmpty()) 
//			throw new Exception("Cartão não encontrado");
//		return this.repository.atualizar(cartao);
//	}

	@Override
	public void remover(Long id) throws Exception {
		if(id == 0) 
			throw new Exception("Cartão não pode ser 0");
		this.repository.deletar(id);
	}

}
