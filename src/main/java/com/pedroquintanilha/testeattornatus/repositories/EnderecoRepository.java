package com.pedroquintanilha.testeattornatus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pedroquintanilha.testeattornatus.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Query(value = "SELECT * FROM ENDERECO u WHERE LOGRADOURO iLIKE %:text%", nativeQuery = true)
	List<Endereco> pegandoEnderecosPrincipais(String text);
	
}
