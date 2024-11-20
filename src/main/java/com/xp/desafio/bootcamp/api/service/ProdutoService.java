package com.xp.desafio.bootcamp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.desafio.bootcamp.api.model.Produto;
import com.xp.desafio.bootcamp.api.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public Produto criarProduto(Produto produto) {
		return repository.save(produto);
	}
	
	public List<Produto> listarTodos() {
		return repository.findAll();
	}
	
	public Produto buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Produto> buscarPorNome(String nome) {
		return repository.findByNomeContainingIgnoreCase(nome);
	}
	
	public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
		Produto produto = buscarPorId(id);
		
		if (produto != null) {
			produto.setNome(produtoAtualizado.getNome());
			produto.setDescricao(produtoAtualizado.getDescricao());
			produto.setPreco(produtoAtualizado.getPreco());
			return repository.save(produto);
		}
		
		return null;
	}
	
	public void deletarProduto(Long id) {
		repository.deleteById(id);
	}
	
	public long contarProdutos() {
		return repository.count();
	}
	
}
