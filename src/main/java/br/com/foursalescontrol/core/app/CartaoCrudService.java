package br.com.foursalescontrol.core.app;

import java.util.List;

import br.com.foursalescontrol.core.domain.Cartao;

public interface CartaoCrudService {

	public Cartao buscar(Long id);
	public List<Cartao> buscarTodos();
	public void incluir(Cartao cartao);
	public void atualizar(Cartao cartao);
	public void deletar(Long id);
	
}
