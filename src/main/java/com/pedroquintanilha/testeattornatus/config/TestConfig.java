package com.pedroquintanilha.testeattornatus.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
	
		
	}
	
}
