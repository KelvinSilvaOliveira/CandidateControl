package br.com.foursalescontrol.core.app;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.foursalescontrol.core.domain.CartaoDeCredito;

@Service
public interface CartaoDeCreditoCrudService {

	public CartaoDeCredito buscar(Long id) throws Exception;
	public List<CartaoDeCredito> buscarTodos();
	public void incluir(CartaoDeCredito CartaoDeCredito, Random randomico) throws Exception;
//	public void atualizar(CartaoDeCredito CartaoDeCredito) throws Exception;
	public void remover(Long id) throws Exception;
	
}
