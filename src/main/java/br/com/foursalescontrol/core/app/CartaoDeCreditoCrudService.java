package br.com.foursalescontrol.core.app;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.foursalescontrol.core.domain.CartaoDeCredito;

@Service
public interface CartaoDeCreditoCrudService {

	public CartaoDeCredito buscar(Long id) throws Exception;
	public List<CartaoDeCredito> buscarTodos();
	public CartaoDeCredito incluir(CartaoDeCredito CartaoDeCredito, Random randomico) throws Exception;
//	public CartaoDeCredito atualizar(CartaoDeCredito CartaoDeCredito) throws Exception;
	public void remover(Long id) throws Exception;
	
}
