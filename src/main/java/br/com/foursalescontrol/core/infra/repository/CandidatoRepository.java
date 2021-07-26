package br.com.foursalescontrol.core.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.foursalescontrol.core.infra.repository.model.CandidatoModel;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoModel, Long> {
	
}
