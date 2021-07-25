package br.com.foursalescontrol.core.infra.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.foursalescontrol.core.domain.Cartao;

public class CartaoJpaRepository implements CartaoRepositoryInterface {
	
	@Autowired
	private CartaoRepository repository;

	@Override
	public Cartao buscar(Long id) {
		return this.repository.findById(id).orElseThrow();
	}
	
	@Override
	public List<Cartao> buscarTodos() {
		return this.repository.findAll();
	}
	
	@Override
	public void salvar(Cartao cartao) {
		this.repository.save(cartao);
	}

	@Override
	public void atualizar(Cartao cartao) {
		this.repository.save(cartao);
	}

	@Override
	public void deletar(Long id) {
		this.repository.deleteById(id);
	}

}
