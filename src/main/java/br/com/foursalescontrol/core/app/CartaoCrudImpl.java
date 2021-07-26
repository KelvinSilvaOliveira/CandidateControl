package br.com.foursalescontrol.core.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.foursalescontrol.core.domain.CartaoDeCredito;
import br.com.foursalescontrol.core.infra.repository.CartaoRepositoryInterface;

@Service
public class CartaoCrudImpl implements CartaoDeCreditoCrudService {
	
	private CartaoRepositoryInterface repository;
	
	public CartaoCrudImpl(@Qualifier("cartaoCreditoJPA") CartaoRepositoryInterface repository) {
		this.repository = repository;
	}

	@Override
	public CartaoDeCredito buscar(Long id) {
		return this.repository.buscar(id);
	}
	
	@Override
	public List<CartaoDeCredito> buscarTodos() {
		return this.repository.buscarTodos();
	}

	@Override
	public void incluir(CartaoDeCredito cartao) {
		this.repository.salvar(cartao);
	}

	@Override
	public void atualizar(CartaoDeCredito cartao) {
		this.repository.atualizar(cartao);
	}

	@Override
	public void remover(Long id) {
		this.repository.deletar(id);
	}

}
