package com.pedroquintanilha.testeattornatus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroquintanilha.testeattornatus.entities.Pessoa;
import com.pedroquintanilha.testeattornatus.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new IllegalArgumentException());
	}

	public Pessoa insert(Pessoa obj) {
		return repository.save(obj);
	}
}
