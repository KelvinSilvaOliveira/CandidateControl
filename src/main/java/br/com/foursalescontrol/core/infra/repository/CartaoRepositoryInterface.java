package br.com.foursalescontrol.core.infra.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.foursalescontrol.core.domain.CartaoDeCredito;

@Repository
public interface CartaoRepositoryInterface {

	CartaoDeCredito salvar(CartaoDeCredito cartao);
	CartaoDeCredito buscar(Long id);
	List<CartaoDeCredito> buscarTodos();
//	CartaoDeCredito atualizar(CartaoDeCredito cartao);
	void deletar(Long id);
	
}
