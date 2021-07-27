package br.com.foursalescontrol.core.app;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service("preparaCartaoDeCredito")
public class PreparaDadosCartaoDeCredito implements PreparaDadosCartao {
	
	private static final Integer TEMPO_VALIDADE = 5;
	private static final Integer NUMERO_CARTAO_MIN = 1000, NUMERO_CARTAO_MAX = 9999;
	private static final Integer CVV_MIN = 100, CVV_MAX = 999;

	@Override
	public String geraNumero(Random randomico) {
		String numero = "";
		for(int i = 0; i < 4; i++) numero = numero.concat(String.valueOf(randomico.nextInt(NUMERO_CARTAO_MAX - NUMERO_CARTAO_MIN) + NUMERO_CARTAO_MIN));
		return numero;
	}

	@Override
	public String montaNomeImpresso(String nome) {
		String[] nomes = nome.split(" ");
		nome = nomes[0] + " " + nomes[nomes.length-1];
		return nome.toUpperCase();
	}

	@Override
	public Integer geraCVV(Random randomico) {
		return randomico.nextInt(CVV_MAX - CVV_MIN) + CVV_MIN;
	}

	@Override
	public LocalDate defineDataValidade() {
		return LocalDate.now().plusYears(TEMPO_VALIDADE);
	}

}
