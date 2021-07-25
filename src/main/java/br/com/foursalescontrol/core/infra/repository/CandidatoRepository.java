package br.com.foursalescontrol.core.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursalescontrol.core.domain.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
	
}
