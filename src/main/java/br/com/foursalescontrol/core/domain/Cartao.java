package br.com.foursalescontrol.core.domain;

import java.time.LocalDate;

import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Cartao {
	
	private Long id;
	
	@Null(message = "Número do cartão não deve ser informado.")
	private String numero;
	
	@Null(message = "Nome não deve ser informado.")
	private String nomeImpresso;
	
	@Null(message = "CVV do cartão não deve ser informado.")
	private Integer cvv;
	
	@Null(message = "Data de validade não deve ser informado.")
	private LocalDate dataValidade;
	
}
