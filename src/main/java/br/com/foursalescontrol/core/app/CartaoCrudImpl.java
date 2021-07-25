package br.com.foursalescontrol.core.app;

import java.util.List;

import br.com.foursalescontrol.core.domain.Cartao;
import br.com.foursalescontrol.core.infra.repository.CartaoRepositoryInterface;

public class CartaoCrudImpl implements CartaoCrudService {
	
	private CartaoRepositoryInterface repository;
	
	public CartaoCrudImpl(CartaoRepositoryInterface repository) {
		this.repository = repository;
	}

	@Override
	public Cartao buscar(Long id) {
		return this.repository.buscar(id);
	}
	
	@Override
	public List<Cartao> buscarTodos() {
		return this.repository.buscarTodos();
	}

	@Override
	public void incluir(Cartao cartao) {
		this.repository.salvar(cartao);
	}

	@Override
	public void atualizar(Cartao cartao) {
		this.repository.atualizar(cartao);
	}

	@Override
	public void deletar(Long id) {
		this.repository.deletar(id);
	}

}
