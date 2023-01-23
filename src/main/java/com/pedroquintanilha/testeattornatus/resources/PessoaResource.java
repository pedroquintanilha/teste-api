package com.pedroquintanilha.testeattornatus.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedroquintanilha.testeattornatus.entities.Pessoa;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@GetMapping
	public ResponseEntity<Pessoa> findAll() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Pessoa p = new Pessoa(1L, "Pedro", sdf.parse("03/04/1994"));
		return ResponseEntity.ok().body(p);
	}
}
