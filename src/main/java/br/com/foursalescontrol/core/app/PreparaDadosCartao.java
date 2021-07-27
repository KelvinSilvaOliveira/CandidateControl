package br.com.foursalescontrol.core.app;

import java.time.LocalDate;
import java.util.Random;

public interface PreparaDadosCartao {

	String geraNumero(Random randomico);
	String montaNomeImpresso(String nome);
	Integer geraCVV(Random randomico);
	LocalDate defineDataValidade();
	
}
