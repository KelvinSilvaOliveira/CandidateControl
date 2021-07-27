package br.com.foursalescontrol.web.controller;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.foursalescontrol.core.app.CartaoDeCreditoCrudService;
import br.com.foursalescontrol.core.domain.CartaoDeCredito;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cartao")
@RequiredArgsConstructor
public class CartaoController {

	private final CartaoDeCreditoCrudService service;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<CartaoDeCredito> buscar(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(this.service.buscar(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<CartaoDeCredito>> buscarTodos() {
		try {
			return ResponseEntity.ok(this.service.buscarTodos());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<CartaoDeCredito> incluir(@RequestBody @Valid CartaoDeCredito cartao) {
		try{
			return new ResponseEntity<>(this.service.incluir(cartao, new Random()), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
//	@PutMapping
//	public ResponseEntity<CartaoDeCredito> atualizar(@RequestBody @Valid CartaoDeCredito cartao) {
//		try{
//			return new ResponseEntity<>(this.service.atualizar(cartao), HttpStatus.ACCEPTED);
//		} catch (Exception e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//		}
//	}
	
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
