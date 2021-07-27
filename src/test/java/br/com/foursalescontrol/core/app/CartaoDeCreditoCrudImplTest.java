package br.com.foursalescontrol.core.app;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.foursalescontrol.core.domain.Candidato;
import br.com.foursalescontrol.core.domain.Cartao;
import br.com.foursalescontrol.core.domain.CartaoDeCredito;
import br.com.foursalescontrol.core.infra.repository.CandidatoRepositoryInterface;
import br.com.foursalescontrol.core.infra.repository.CartaoRepositoryInterface;

@ExtendWith(SpringExtension.class)
public class CartaoDeCreditoCrudImplTest {
	
	@InjectMocks
	private CartaoDeCreditoCrudImpl servico;
	
	@Mock
	private CartaoRepositoryInterface repository;
	
	@Mock
	private CandidatoRepositoryInterface candidatoRepository;
	
	@Mock
	private PreparaDadosCartao dadosCartao;
	
	@Test
	public void buscar_Sucesso() throws Exception {
		Mockito.when(this.repository.buscar(Mockito.anyLong())).thenReturn(createCartao());
		
		Cartao retorno = this.servico.buscar(1l);
		
		Assertions.assertThat(retorno)
					.isNotNull()
					.isEqualTo(createCartao());
	}
	
	@Test
	public void buscar_Excessao() throws Exception {
		Mockito.when(this.repository.buscar(Mockito.anyLong())).thenThrow(new RuntimeException());
		
		Assertions.assertThatExceptionOfType(RuntimeException.class)
					.isThrownBy(() -> this.servico.buscar(1l));
	}
	
	@Test
	public void buscarTodos_Sucesso() throws Exception {
		List<CartaoDeCredito> listaCandidatos = List.of(createCartao());
		Mockito.when(this.repository.buscarTodos()).thenReturn(listaCandidatos);
		
		List<CartaoDeCredito> retorno = this.servico.buscarTodos();
		
		Assertions.assertThat(retorno)
					.isNotNull()
					.contains(createCartao());
	}
	
	@Test
	public void buscarTodos_Excessao() throws Exception {
		Mockito.when(this.repository.buscarTodos()).thenThrow(new RuntimeException());
		
		Assertions.assertThatExceptionOfType(RuntimeException.class)
					.isThrownBy(() -> this.servico.buscarTodos());
	}
	
	@Test
	public void incluir_Sucesso() throws Exception {
		Mockito.when(this.candidatoRepository.buscar(Mockito.anyLong())).thenReturn(createCandidato());
		Mockito.when(this.repository.salvar(Mockito.any(CartaoDeCredito.class))).thenReturn(createCartao());
		
		CartaoDeCredito retorno = this.servico.incluir(createCartao(), new Random());
		
		Assertions.assertThat(retorno)
					.isNotNull()
					.isEqualTo(createCartao());
	}
	
	@Test
	public void incluir_Excessao() throws Exception {
		Mockito.when(this.repository.salvar(Mockito.any(CartaoDeCredito.class))).thenThrow(new RuntimeException());
		
		Assertions.assertThatExceptionOfType(RuntimeException.class)
					.isThrownBy(() -> this.servico.incluir(createCartao(), new Random()));
	}
	
	@Test
	public void remover_Sucesso() throws Exception {
		Mockito.doNothing().when(this.repository).deletar(Mockito.anyLong());
		
		Assertions.assertThatCode(() -> this.servico.remover(1l)).doesNotThrowAnyException();
	}
	
	@Test
	public void remover_Excessao() throws Exception {
		Mockito.doThrow(new RuntimeException()).when(this.repository).deletar(Mockito.anyLong());
		
		Assertions.assertThatExceptionOfType(RuntimeException.class)
					.isThrownBy(() -> this.servico.remover(1l));
	}
	
	private CartaoDeCredito createCartao() {
		return new CartaoDeCredito(1l, "0000000000000000", "TESTE", 123, LocalDate.now(), createCandidato());
	}
	
	private Candidato createCandidato() {
		return new Candidato(1l, "Teste", "00000000000", null);
	}
}
