package com.pedroquintanilha.testeattornatus.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedroquintanilha.testeattornatus.entities.Endereco;
import com.pedroquintanilha.testeattornatus.entities.Pessoa;
import com.pedroquintanilha.testeattornatus.repositories.EnderecoRepository;
import com.pedroquintanilha.testeattornatus.repositories.PessoaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Pessoa p1 = new Pessoa(null, "Pedro", sdf.parse("03/04/1994"));
		Pessoa p2 = new Pessoa(null, "Lucas", sdf.parse("15/11/1992"));
		
		Endereco e1 = new Endereco(null, "Rua 1", 324234234L, 453, "Cidade 1", p1);
		Endereco e2 = new Endereco(null, "Rua 2", 234234L, 23, "Cidade 2", p1);
		Endereco e3 = new Endereco(null, "Rua 3", 658658658L, 1003, "Cidade 3", p2);
		Endereco e4 = new Endereco(null, "Rua 4", 42526373L, 7, "Cidade 4", p2);
		Endereco e5 = new Endereco(null, "Rua 5", 121324325L, 39, "Cidade 5", p1);
		
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
	
		
	}
	
}
