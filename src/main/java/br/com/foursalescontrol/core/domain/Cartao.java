package br.com.foursalescontrol.core.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Cartao {
	
	private String numero;
	private String nomeImpresso;
	private Integer cvv;
	private LocalDate dataValidade;
	
}
