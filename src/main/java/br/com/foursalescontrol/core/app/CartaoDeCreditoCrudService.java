package br.com.foursalescontrol.core.app;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.foursalescontrol.core.domain.CartaoDeCredito;

@Service
public interface CartaoDeCreditoCrudService {

	public CartaoDeCredito buscar(Long id);
	public List<CartaoDeCredito> buscarTodos();
	public void incluir(CartaoDeCredito CartaoDeCredito);
	public void atualizar(CartaoDeCredito CartaoDeCredito);
	public void remover(Long id);
	
}
