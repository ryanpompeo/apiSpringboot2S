package com.example.apiSpringProjectV2.repository;


import com.example.apiSpringProjectV2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	List<Produto> findByCodigo(int codigo);
	
	List<Produto> findByMarca(String marca);
    
    @Query(value = "select p from Produto p where p.descricao like %?1%")
	List<Produto> findByDescricao(String descricao);
    
    @Query(value = "select p from Produto p where p.preco < ?1")
	List<Produto> findByPrecoMenorQue(Double preco);
    
    @Query(value = "select p from Produto p where p.marca like %?1% and p.preco < ?2")
	List<Produto> findByMarcaPreco(String marca, double preco);
	
}
