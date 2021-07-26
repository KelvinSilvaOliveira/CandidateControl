package br.com.foursalescontrol.core.infra.repository;

import java.util.List;

import br.com.foursalescontrol.core.domain.Cartao;

@Repository
public interface CartaoRepositoryInterface {

	void salvar(Cartao cartao);
	Cartao buscar(Long id);
	List<Cartao> buscarTodos();
	void atualizar(Cartao cartao);
	void deletar(Long id);
	
}
