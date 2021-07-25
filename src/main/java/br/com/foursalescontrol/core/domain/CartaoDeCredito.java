package br.com.foursalescontrol.core.domain;

import java.time.LocalDate;

public class CartaoDeCredito extends Cartao {
	
	public CartaoDeCredito(String numero, String nomeImpresso, Integer cvv, LocalDate dataValidade) {
		super(numero, nomeImpresso, cvv, dataValidade);
	}

}
