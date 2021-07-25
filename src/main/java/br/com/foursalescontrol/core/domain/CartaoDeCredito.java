package br.com.foursalescontrol.core.domain;

import java.time.LocalDate;

public class CartaoDeCredito extends Cartao {
	
	public CartaoDeCredito(Long id, String numero, String nomeImpresso, Integer cvv, LocalDate dataValidade) {
		super(id, numero, nomeImpresso, cvv, dataValidade);
	}

}
