package br.com.foursalescontrol.core.infra.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import br.com.foursalescontrol.core.infra.repository.model.CandidatoModel;

@DataJpaTest
public class CandidatoRepositoryTest {
	
	@Autowired
	private CandidatoRepository repository;
	
	@Test
	public void findById_Sucesso() {
		CandidatoModel candidatoSalvo = this.repository.save(createCandidato());
		
		Optional<CandidatoModel> candidato = this.repository.findById(candidatoSalvo.getId());
		
		Assertions.assertThat(candidato).isNotEmpty();
		Assertions.assertThat(candidato.orElseThrow().getNome()).isEqualTo(candidatoSalvo.getNome());
	}
	
	@Test
	public void findById_Erro() {
		Optional<CandidatoModel> candidato = this.repository.findById(createCandidato().getId());
		
		Assertions.assertThat(candidato).isEmpty();
	}
	
	@Test
	public void findById_Excessao_IdNull() {
		Assertions.assertThatThrownBy(() -> this.repository.findById(null))
					.isInstanceOf(InvalidDataAccessApiUsageException.class);
	}
	
	@Test
	public void findAll_Sucesso() {
		CandidatoModel candidatoSalvo = this.repository.save(createCandidato());
		
		List<CandidatoModel> candidatos = this.repository.findAll();
		
		Assertions.assertThat(candidatos)
					.isNotEmpty()
					.contains(candidatoSalvo);
	}
	
	@Test
	public void findAll_Vazio() {
		List<CandidatoModel> candidatos = this.repository.findAll();
		
		Assertions.assertThat(candidatos).isEmpty();
	}

	@Test
	public void save_Sucesso() {
		CandidatoModel candidatoASalvar = createCandidato();
		
		CandidatoModel candidatoSalvo = this.repository.save(candidatoASalvar);
		
		Assertions.assertThat(candidatoSalvo).isNotNull();
		Assertions.assertThat(candidatoSalvo.getId()).isEqualTo(candidatoSalvo.getId());
		Assertions.assertThat(candidatoSalvo.getNome()).isEqualTo(candidatoSalvo.getNome());
		Assertions.assertThat(candidatoSalvo.getCpf()).isEqualTo(candidatoSalvo.getCpf());
		Assertions.assertThat(candidatoSalvo.getCartoes()).isEqualTo(candidatoSalvo.getCartoes());
	}
	
	@Test
	public void save_Vazio() {
		CandidatoModel candidatoASalvar = new CandidatoModel();
		
		CandidatoModel candidatoSalvo = this.repository.save(candidatoASalvar);
		
		Assertions.assertThat(candidatoSalvo).isNotNull();
		Assertions.assertThat(candidatoSalvo.getId()).isEqualTo(candidatoSalvo.getId());
		Assertions.assertThat(candidatoSalvo.getNome()).isEqualTo(candidatoSalvo.getNome());
		Assertions.assertThat(candidatoSalvo.getCpf()).isEqualTo(candidatoSalvo.getCpf());
		Assertions.assertThat(candidatoSalvo.getCartoes()).isEqualTo(candidatoSalvo.getCartoes());
	}
	
	@Test
	public void seve_Excessao_CandidatoNull() {
		Assertions.assertThatThrownBy(() -> this.repository.save(null))
					.isInstanceOf(InvalidDataAccessApiUsageException.class);
	}
	
	@Test
	public void update_Sucesso() {
		CandidatoModel candidatoSalvo = this.repository.save(createCandidato());
		
		candidatoSalvo.setNome("Atualizado");
		
		CandidatoModel candidatoAtualizado = this.repository.save(candidatoSalvo);
		
		Assertions.assertThat(candidatoAtualizado).isNotNull();
		Assertions.assertThat(candidatoAtualizado.getId()).isEqualTo(candidatoSalvo.getId());
		Assertions.assertThat(candidatoAtualizado.getNome()).isEqualTo(candidatoSalvo.getNome());
		Assertions.assertThat(candidatoAtualizado.getCpf()).isEqualTo(candidatoSalvo.getCpf());
		Assertions.assertThat(candidatoAtualizado.getCartoes()).isEqualTo(candidatoSalvo.getCartoes());
	}
	
	@Test
	public void update_SemAlteracao() {
		CandidatoModel candidatoSalvo = this.repository.save(createCandidato());
		
		CandidatoModel candidatoAtualizado = this.repository.save(candidatoSalvo);
		
		Assertions.assertThat(candidatoAtualizado).isNotNull();
		Assertions.assertThat(candidatoAtualizado.getId()).isEqualTo(candidatoSalvo.getId());
		Assertions.assertThat(candidatoAtualizado.getNome()).isEqualTo(candidatoSalvo.getNome());
		Assertions.assertThat(candidatoAtualizado.getCpf()).isEqualTo(candidatoSalvo.getCpf());
		Assertions.assertThat(candidatoAtualizado.getCartoes()).isEqualTo(candidatoSalvo.getCartoes());
	}
	
	@Test
	public void delete_Sucesso() {
		CandidatoModel candidatoSalvo = this.repository.save(createCandidato());
		
		this.repository.delete(candidatoSalvo);
		
		Optional<CandidatoModel> candidatoDeletado = this.repository.findById(candidatoSalvo.getId());
		
		Assertions.assertThat(candidatoDeletado).isEmpty();
	}
	
	@Test
	public void delete_Excessao_CandidatoNull() {
		Assertions.assertThatThrownBy(() -> this.repository.delete(null))
					.isInstanceOf(InvalidDataAccessApiUsageException.class);
	}
	
	private CandidatoModel createCandidato() {
		return CandidatoModel.builder()
							 .id(1l)
							 .nome("Teste")
							 .cpf("000000000000")
							 .cartoes(null)
							 .build();
	}
	
}
