package br.com.foursalescontrol.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.foursalescontrol.core.app.CandidatoCrudService;
import br.com.foursalescontrol.core.domain.Candidato;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("candidatos")
@RequiredArgsConstructor
public class CandidatoController {
	
	private final CandidatoCrudService service;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Candidato> buscar(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(this.service.buscar(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Candidato>> buscarTodos() {
		try {
			return ResponseEntity.ok(this.service.buscarTodos());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<Candidato> incluir(@RequestBody @Valid Candidato candidato) {
		try{
			return new ResponseEntity<>(this.service.incluir(candidato), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<Candidato> atualizar(@RequestBody @Valid Candidato candidato) {
		try{
			return new ResponseEntity<>(this.service.atualizar(candidato), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		try{
			this.service.remover(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
