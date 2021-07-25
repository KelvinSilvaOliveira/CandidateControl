package br.com.foursalescontrol.core.infra.repository;

import java.util.List;

import br.com.foursalescontrol.core.domain.Cartao;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartaoJpaRepository implements CartaoRepositoryInterface {
	
	private final CartaoRepository repository;

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
