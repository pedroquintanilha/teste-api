package com.pedroquintanilha.testeattornatus.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.pedroquintanilha.testeattornatus.dto.EnderecoDTO;
import com.pedroquintanilha.testeattornatus.entities.Endereco;

import com.pedroquintanilha.testeattornatus.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Método para poder utilizar a URI gerada no PostMapping.
	@GetMapping(value = "/{id_pessoa}/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		Endereco obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Endereco> insert(@PathVariable Long id, @RequestBody EnderecoDTO objDto) throws ParseException{
		Endereco obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	/*
	 * Considerando que o endereço principal sempre estará constando no logradouro
	 * através da palavra "principal", e que cada Pessoa só pode ter um endereço principal,
	 * tendo sempre pelo menos um.
	 */ 
	@GetMapping(value="/{id_pessoa}/logradouro")
	public ResponseEntity<Endereco> findEnderecoPrincipal(@PathVariable Long id_pessoa, @RequestParam(value="text", defaultValue = "") String text) {
		Endereco obj = service.findEnderecoPrincipal(text, id_pessoa);
		return ResponseEntity.ok().body(obj);	
	}
	
}
