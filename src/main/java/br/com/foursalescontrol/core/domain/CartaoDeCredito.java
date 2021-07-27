package br.com.foursalescontrol.core.domain;

import java.time.LocalDate;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoDeCredito extends Cartao {
	
	@NotNull
	private Candidato candidato;
	
	public CartaoDeCredito(Long id, String numero, String nomeImpresso, Integer cvv, LocalDate dataValidade, Candidato candidato) {
		super(id, numero, nomeImpresso, cvv, dataValidade);
		this.candidato = candidato;
	}

}
