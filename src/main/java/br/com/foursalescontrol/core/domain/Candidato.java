package br.com.foursalescontrol.core.domain;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidato {
	
	private Long id;
	
	@NotEmpty(message = "Nome deve ser informado.")
	private String nome;
	
	@NotEmpty(message = "CPF deve ser informado.")
	@Pattern(regexp = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}", message = "CPF deve ser correto.")
	private String cpf;
	
	@Null(message = "Cartões não devem ser informados.")
	private List<Cartao> cartoes;
	
}
