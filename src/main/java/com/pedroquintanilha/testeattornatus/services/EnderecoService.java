package com.pedroquintanilha.testeattornatus.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroquintanilha.testeattornatus.dto.EnderecoDTO;
import com.pedroquintanilha.testeattornatus.entities.Endereco;
import com.pedroquintanilha.testeattornatus.repositories.EnderecoRepository;

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
	
	public Endereco fromDTO(EnderecoDTO objDto) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		objDto.getPessoa().setDataDeNascimento(sdf.parse(sdf.format(objDto.getPessoa().getDataDeNascimento())));
		return new Endereco(null, objDto.getLogradouro(), objDto.getCep(), objDto.getNumero(), objDto.getCidade(), objDto.getPessoa());
	}

	
}
