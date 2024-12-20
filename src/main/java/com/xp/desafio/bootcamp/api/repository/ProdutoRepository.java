package com.xp.desafio.bootcamp.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xp.desafio.bootcamp.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
    List<Produto> findByNomeContainingIgnoreCase(String nome);

}
