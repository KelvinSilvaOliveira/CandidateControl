package br.com.foursalescontrol.core.app;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.foursalescontrol.core.domain.Candidato;
import br.com.foursalescontrol.core.infra.repository.CandidatoRepositoryInterface;

@ExtendWith(SpringExtension.class)
public class CandidatoCrudImplTest {
	
	@InjectMocks
	private CandidatoCrudImpl servico;
	
	@Mock
	private CandidatoRepositoryInterface repository;
	
	@Test
	public void buscar_Sucesso() throws Exception {
		Mockito.when(this.repository.buscar(Mockito.anyLong())).thenReturn(createCandidato());
		
		Candidato retorno = this.servico.buscar(1l);
		
		Assertions.assertThat(retorno)
					.isNotNull()
					.isEqualTo(createCandidato());
	}
	
	@Test
	public void buscar_Excessao() throws Exception {
		Mockito.when(this.repository.buscar(Mockito.anyLong())).thenThrow(new RuntimeException());
		
		Assertions.assertThatExceptionOfType(RuntimeException.class)
					.isThrownBy(() -> this.servico.buscar(1l));
	}
	
	@Test
	public void buscarTodos_Sucesso() throws Exception {
		List<Candidato> listaCandidatos = List.of(createCandidato());
		Mockito.when(this.repository.buscarTodos()).thenReturn(listaCandidatos);
		
		List<Candidato> retorno = this.servico.buscarTodos();
		
		Assertions.assertThat(retorno)
					.isNotNull()
					.contains(createCandidato());
	}
	
	@Test
	public void buscarTodos_Excessao() throws Exception {
		Mockito.when(this.repository.buscarTodos()).thenThrow(new RuntimeException());
		
		Assertions.assertThatExceptionOfType(RuntimeException.class)
					.isThrownBy(() -> this.servico.buscarTodos());
	}
	
	@Test
	public void incluir_Sucesso() throws Exception {
		Mockito.when(this.repository.salvar(Mockito.any(Candidato.class))).thenReturn(createCandidato());
		
		Candidato retorno = this.servico.incluir(createCandidato());
		
		Assertions.assertThat(retorno)
					.isNotNull()
					.isEqualTo(createCandidato());
	}
	
	@Test
	public void incluir_Excessao() throws Exception {
		Mockito.when(this.repository.salvar(Mockito.any(Candidato.class))).thenThrow(new RuntimeException());
		
		Assertions.assertThatExceptionOfType(RuntimeException.class)
					.isThrownBy(() -> this.servico.incluir(createCandidato()));
	}
	
	@Test
	public void atualizar_Sucesso() throws Exception {
		Mockito.when(this.repository.buscar(Mockito.anyLong())).thenReturn(createCandidato());
		Mockito.when(this.repository.atualizar(Mockito.any(Candidato.class))).thenReturn(createCandidato());
		
		Candidato retorno = this.servico.atualizar(createCandidato());
		
		Assertions.assertThat(retorno)
					.isNotNull()
					.isEqualTo(createCandidato());
	}
	
	@Test
	public void atualizar_Excessao() throws Exception {
		Mockito.when(this.repository.atualizar(Mockito.any(Candidato.class))).thenThrow(new RuntimeException());
		
		Assertions.assertThatExceptionOfType(RuntimeException.class)
					.isThrownBy(() -> this.servico.atualizar(createCandidato()));
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
	
	private Candidato createCandidato() {
		return new Candidato(1l, "Teste", "00000000000", null);
	}
	
}
