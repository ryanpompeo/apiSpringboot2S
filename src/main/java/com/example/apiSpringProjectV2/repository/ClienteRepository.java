package com.example.apiSpringProjectV2.repository;

import com.example.apiSpringProjectV2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	List<Cliente> findByCodigo(int codigo);
	
	List<Cliente> findByEmail(String email);
	
	@Query(value = "select c from Cliente c where c.nome like %?1%")
	List<Cliente> findByParteNome(String nome);
	
	@Query(value = "select c from Cliente c where c.nome like %?1% and c.email like %?2%")
	List<Cliente> findByNomeEmail(String nome, String email);
}
