package br.com.foursalescontrol.core.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursalescontrol.core.domain.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
	
}
