package br.com.foursalescontrol.core.domain;

import java.util.List;

import lombok.Data;

@Data
public class Candidato {
	
	private Long id; 
	private String nome;
	private String cpf;
	private List<Cartao> cartoes;
	
}
