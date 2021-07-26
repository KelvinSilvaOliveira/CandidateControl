package br.com.foursalescontrol.core.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Cartao {
	
	private Long id;
	private String numero;
	private String nomeImpresso;
	private Integer cvv;
	private LocalDate dataValidade;
	
}
