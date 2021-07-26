package br.com.foursalescontrol.core.domain;

import java.util.List;

import javax.validation.constraints.NotEmpty;
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
	private String nome;
	private String cpf;
	private List<Cartao> cartoes;
	
}
