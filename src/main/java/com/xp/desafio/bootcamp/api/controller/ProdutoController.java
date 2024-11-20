package com.xp.desafio.bootcamp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xp.desafio.bootcamp.api.model.Produto;
import com.xp.desafio.bootcamp.api.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@PostMapping
	public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
		Produto novoProduto = service.criarProduto(produto);
		return ResponseEntity.ok(novoProduto);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Produto produto = service.buscarPorId(id);
		return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(service.buscarPorNome(nome));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
		Produto produto = service.atualizarProduto(id, produtoAtualizado);
		return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
		service.deletarProduto(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/count")
	public ResponseEntity<Long> contarProdutos() {
		return ResponseEntity.ok(service.contarProdutos());
	}
	
}
