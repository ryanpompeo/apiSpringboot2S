package com.example.apiSpringProjectV2.controller;


import com.example.apiSpringProjectV2.model.Produto;
import com.example.apiSpringProjectV2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiProjeto2SProduto")
public class ProdutoControl {
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostMapping("/cadastrarProduto")
	public List<Produto> cadastrarProduto(@RequestBody Produto produto) {
		produtoRepository.save(produto);
		return this.buscarTodosProdutos();
	}
	
	
	@GetMapping("/todosProduto")
	public List<Produto> buscarTodosProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/buscarProdutoCodigo/{codigo}")
	public List<Produto> buscarProdutoCodigo(@PathVariable int codigo) {
		return produtoRepository.findByCodigo(codigo);
	}
	
	@GetMapping("/buscaParteDescricao/{descricao}")
	public List<Produto> buscarParteDescricao(@PathVariable(value = "descricao") String descricao) {
		return produtoRepository.findByDescricao(descricao);
	}
	
	@GetMapping("/buscarPrecoMenorQue/{preco}")
	public List<Produto> buscarPrecoMenorQue(@PathVariable(value = "preco") double preco) {
		return produtoRepository.findByPrecoMenorQue(preco);
	}
	
	@GetMapping("/buscarMarca/{marca}")
	public List<Produto> buscarPorMarca(@PathVariable(value = "marca") String marca) {
		return produtoRepository.findByMarca(marca);
	}
	
	@GetMapping("/buscarMarcaPrecoMenor/{marca}/{preco}")
	public List<Produto> buscarParteMarcaPreco(@PathVariable(value = "marca") String marca,
											   @PathVariable(value = "preco") double preco) {
		
		return produtoRepository.findByMarcaPreco(marca, preco);
		
	}
	
	@DeleteMapping("/deleteProdutoRegistroCompleto")
	public List<Produto> deleteProdutoRegistroCompleto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
		return this.buscarTodosProdutos();
	}
	
	
	@DeleteMapping("/deleteProdutoId/{id}")
	public List<Produto> deleteProdutpCodigo(@PathVariable int codigo) {
		produtoRepository.deleteById(codigo);
		return this.buscarTodosProdutos();
	}
	
	@PutMapping("/atualizarProduto")
	public List<Produto> atualizarProduto(@RequestBody Produto produto) {
		produtoRepository.save(produto);
		return this.buscarTodosProdutos();
	}
	
	
}
