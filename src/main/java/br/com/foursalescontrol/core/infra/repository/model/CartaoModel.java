package br.com.foursalescontrol.core.infra.repository.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cartao")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartaoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	private String nomeImpresso;
	private Integer cvv;
	private LocalDate dataValidade;
	
}
