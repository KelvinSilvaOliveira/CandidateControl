package br.com.foursalescontrol.web.controller;

import java.util.List;
import java.util.Random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import br.com.foursalescontrol.core.app.CartaoDeCreditoCrudService;
import br.com.foursalescontrol.core.domain.CartaoDeCredito;

@ExtendWith(SpringExtension.class)
public class CartaoControllerTest {
	
	@InjectMocks
	private CartaoController controller;
	
	@Mock
	private CartaoDeCreditoCrudService service;
	
	@Test
	public void buscar_Sucesso() throws Exception {
		Mockito.when(this.service.buscar(Mockito.anyLong())).thenReturn(createCartao());
		
		ResponseEntity<CartaoDeCredito> retorno = this.controller.buscar(1l);
		
		Assertions.assertThat(retorno).isNotNull();
		Assertions.assertThat(retorno.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test
	public void buscar_Excessao() throws Exception {
		Mockito.when(this.service.buscar(Mockito.anyLong())).thenThrow(new Exception());
		
		Assertions.assertThatExceptionOfType(ResponseStatusException.class)
					.isThrownBy(() -> this.controller.buscar(1l))
					.withMessageContaining(HttpStatus.BAD_REQUEST.toString());
	}
	
	@Test
	public void buscarTodos_Sucesso() throws Exception {
		List<CartaoDeCredito> listaCandidatos = List.of(createCartao());
		Mockito.when(this.service.buscarTodos()).thenReturn(listaCandidatos);
		
		ResponseEntity<List<CartaoDeCredito>> retorno = this.controller.buscarTodos();
		
		Assertions.assertThat(retorno).isNotNull();
		Assertions.assertThat(retorno.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test
	public void buscarTodos_Excessao() throws Exception {
		Mockito.when(this.service.buscarTodos()).thenThrow(new RuntimeException());
		
		Assertions.assertThatExceptionOfType(ResponseStatusException.class)
					.isThrownBy(() -> this.controller.buscarTodos())
					.withMessageContaining(HttpStatus.BAD_REQUEST.toString());
	}
	
	@Test
	public void incluir_Sucesso() throws Exception {
		Mockito.when(this.service.incluir(Mockito.any(CartaoDeCredito.class), Mockito.any(Random.class))).thenReturn(createCartao());
		
		ResponseEntity<CartaoDeCredito> retorno = this.controller.incluir(createCartao());
		
		Assertions.assertThat(retorno).isNotNull();
		Assertions.assertThat(retorno.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());
	}
	
	@Test
	public void incluir_Excessao() throws Exception {
		Mockito.when(this.service.incluir(Mockito.any(CartaoDeCredito.class), Mockito.any(Random.class))).thenThrow(new RuntimeException());
		
		Assertions.assertThatExceptionOfType(ResponseStatusException.class)
					.isThrownBy(() -> this.controller.incluir(createCartao()))
					.withMessageContaining(HttpStatus.BAD_REQUEST.toString());
	}
	
	@Test
	public void remover_Sucesso() throws Exception {
		Mockito.doNothing().when(this.service).remover(Mockito.anyLong());
		
		ResponseEntity<Void> retorno = this.controller.remover(1l);
		
		Assertions.assertThat(retorno).isNotNull();
		Assertions.assertThat(retorno.getStatusCodeValue()).isEqualTo(HttpStatus.ACCEPTED.value());
	}
	
	@Test
	public void remover_Excessao() throws Exception {
		Mockito.doThrow(new RuntimeException()).when(this.service).remover(Mockito.anyLong());
		
		Assertions.assertThatExceptionOfType(ResponseStatusException.class)
					.isThrownBy(() -> this.controller.remover(1l))
					.withMessageContaining(HttpStatus.BAD_REQUEST.toString());
	}
	
	private CartaoDeCredito createCartao() {
		return new CartaoDeCredito(null, null, null, null, null, null);
	}

}