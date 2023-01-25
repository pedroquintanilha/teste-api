package com.pedroquintanilha.testeattornatus.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.pedroquintanilha.testeattornatus.dto.EnderecoDTO;
import com.pedroquintanilha.testeattornatus.entities.Endereco;

import com.pedroquintanilha.testeattornatus.repositories.EnderecoRepository;
import com.pedroquintanilha.testeattornatus.services.exceptions.ResourceNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;

	public Endereco insert(Endereco obj) {
		return repository.save(obj);
	}

	public List<Endereco> findAll() {
		return repository.findAll();
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Endereco fromDTO(EnderecoDTO objDto) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		objDto.getPessoa().setDataDeNascimento(sdf.parse(sdf.format(objDto.getPessoa().getDataDeNascimento())));
		return new Endereco(null, objDto.getLogradouro(), objDto.getCep(), objDto.getNumero(), objDto.getCidade(), objDto.getPessoa());
	}
	
	public Endereco findEnderecoPrincipal(String text, Long id) {
		List<Endereco> endereco = repository.pegandoEnderecosPrincipais(text).stream().filter(e -> e.getPessoa().getId() == id).collect(Collectors.toList());
		return endereco.get(0);
	}


	
}
