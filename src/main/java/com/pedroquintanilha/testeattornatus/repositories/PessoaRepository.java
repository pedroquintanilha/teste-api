package com.pedroquintanilha.testeattornatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedroquintanilha.testeattornatus.entities.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
