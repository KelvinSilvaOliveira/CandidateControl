package br.com.foursalescontrol.core.infra.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import br.com.foursalescontrol.core.infra.repository.model.CandidatoModel;
import br.com.foursalescontrol.core.infra.repository.model.CartaoModel;

@DataJpaTest
public class CartaoRepositoryTest {
	
	@Autowired
	private CartaoRepository repository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Test
	public void findById_Sucesso() {
		CandidatoModel candidatoSalvo = this.candidatoRepository.save(createCandidato());
		CartaoModel cartaoSalvo = this.repository.save(createCartao(candidatoSalvo));
		
		Optional<CartaoModel> cartao = this.repository.findById(cartaoSalvo.getId());
		
		Assertions.assertThat(cartao).isNotEmpty();
		Assertions.assertThat(cartao.orElseThrow().getNomeImpresso()).isEqualTo(cartaoSalvo.getNomeImpresso());
	}
	
	@Test
	public void findById_Erro() {
		CandidatoModel candidatoSalvo = this.candidatoRepository.save(createCandidato());
		Optional<CartaoModel> cartao = this.repository.findById(createCartao(candidatoSalvo).getId());
		
		Assertions.assertThat(cartao).isEmpty();
	}
	
	@Test
	public void findById_Excessao_IdNull() {
		Assertions.assertThatThrownBy(() -> this.repository.findById(null))
					.isInstanceOf(InvalidDataAccessApiUsageException.class);
	}
	
	@Test
	public void findAll_Sucesso() {
		CandidatoModel candidatoSalvo = this.candidatoRepository.save(createCandidato());
		CartaoModel cartaoSalvo = this.repository.save(createCartao(candidatoSalvo));
		
		List<CartaoModel> cartoes = this.repository.findAll();
		
		Assertions.assertThat(cartoes)
					.isNotEmpty()
					.contains(cartaoSalvo);
	}
	
	@Test
	public void findAll_Vazio() {
		List<CartaoModel> cartoes = this.repository.findAll();
		
		Assertions.assertThat(cartoes).isEmpty();
	}

	@Test
	public void save_Sucesso() {
		CandidatoModel candidatoSalvo = this.candidatoRepository.save(createCandidato());
		CartaoModel cartaoASalvar = createCartao(this.candidatoRepository.save(candidatoSalvo));
		
		CartaoModel cartaoSalvo = this.repository.save(cartaoASalvar);
		
		Assertions.assertThat(cartaoSalvo).isNotNull();
		Assertions.assertThat(cartaoSalvo.getNomeImpresso()).isEqualTo(cartaoASalvar.getNomeImpresso());
	}
	
	@Test
	public void save_Vazio() {
		CandidatoModel candidatoSalvo = this.candidatoRepository.save(createCandidato());
		CartaoModel cartaoASalvar = new CartaoModel();
		cartaoASalvar.setCandidato(candidatoSalvo);
		
		CartaoModel cartaoSalvo = this.repository.save(cartaoASalvar);
		
		Assertions.assertThat(cartaoSalvo).isNotNull();
		Assertions.assertThat(cartaoSalvo.getId()).isEqualTo(cartaoASalvar.getId());
		Assertions.assertThat(cartaoSalvo.getNomeImpresso()).isEqualTo(cartaoASalvar.getNomeImpresso());
		Assertions.assertThat(cartaoSalvo.getNumero()).isEqualTo(cartaoASalvar.getNumero());
		Assertions.assertThat(cartaoSalvo.getCvv()).isEqualTo(cartaoASalvar.getCvv());
		Assertions.assertThat(cartaoSalvo.getDataValidade()).isEqualTo(cartaoASalvar.getDataValidade());
		Assertions.assertThat(cartaoSalvo.getCandidato()).isEqualTo(cartaoASalvar.getCandidato());
	}
	
	@Test
	public void seve_Excessao_CartaoNull() {
		Assertions.assertThatThrownBy(() -> this.repository.save(null))
					.isInstanceOf(InvalidDataAccessApiUsageException.class);
	}
	
	@Test
	public void update_Sucesso() {
		CandidatoModel candidatoSalvo = this.candidatoRepository.save(createCandidato());
		CartaoModel cartaoSalvo = this.repository.save(createCartao(candidatoSalvo));
		
		cartaoSalvo.setNomeImpresso("ATUALIZADO");
		
		CartaoModel cartaoAtualizado = this.repository.save(cartaoSalvo);
		
		Assertions.assertThat(cartaoAtualizado).isNotNull();
		Assertions.assertThat(cartaoAtualizado.getNomeImpresso()).isEqualTo(cartaoSalvo.getNomeImpresso());
	}
	
	@Test
	public void update_SemAlteracao() {
		CandidatoModel candidatoSalvo = this.candidatoRepository.save(createCandidato());
		CartaoModel cartaoSalvo = this.repository.save(createCartao(candidatoSalvo));
		
		CartaoModel cartaoAtualizado = this.repository.save(cartaoSalvo);
		
		Assertions.assertThat(cartaoAtualizado).isNotNull();
		Assertions.assertThat(cartaoAtualizado.getNomeImpresso()).isEqualTo(cartaoSalvo.getNomeImpresso());
	}
	
	@Test
	public void delete_Sucesso() {
		CandidatoModel candidatoSalvo = this.candidatoRepository.save(createCandidato());
		CartaoModel cartaoSalvo = this.repository.save(createCartao(candidatoSalvo));
		
		this.repository.delete(cartaoSalvo);
		
		Optional<CartaoModel> cartaoDeletado = this.repository.findById(cartaoSalvo.getId());
		
		Assertions.assertThat(cartaoDeletado).isEmpty();
	}
	
	@Test
	public void delete_Excessao_CartaoNull() {
		Assertions.assertThatThrownBy(() -> this.repository.delete(null))
					.isInstanceOf(InvalidDataAccessApiUsageException.class);
	}

	
	private CartaoModel createCartao(CandidatoModel candidato) {
		return CartaoModel.builder()
						  .id(1l)
						  .nomeImpresso("TESTE")
						  .numero("0000000000")
						  .cvv(123)
						  .dataValidade(LocalDate.now())
						  .candidato(candidato)
						  .build();
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