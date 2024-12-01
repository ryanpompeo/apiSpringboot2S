package com.example.apiSpringProjectV2.controller;

import com.example.apiSpringProjectV2.model.Cliente;
import com.example.apiSpringProjectV2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiProjeto2SCliente")
public class ClienteControl {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping("/cadastrarCliente")
	public List<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return this.buscarTodosClientes();
	}
	
	@GetMapping("/todosClientes")
	public List<Cliente> buscarTodosClientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/buscarClienteCodigo/{codigo}")
	public List<Cliente> buscarClienteCodigo(@PathVariable int codigo) {
		return clienteRepository.findByCodigo(codigo);
	}
	
	@GetMapping("/buscarClienteEmail/{email}")
	public List<Cliente> buscarClienteEmail(@PathVariable String email) {
		return clienteRepository.findByEmail(email);
	}
	
	@DeleteMapping("/deleteClienteRegistroCompleto")
	public List<Cliente> deleteClienteRegistroCompleto(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
		return this.buscarTodosClientes();
	}
	
	@DeleteMapping("/deleteClienteId/{id}")
	public List<Cliente> deleteClienteCodigo(@PathVariable int codigo) {
		clienteRepository.deleteById(codigo);
		return this.buscarTodosClientes();
	}
	
	@PutMapping("/atualizarCliente")
	public List<Cliente> atualizarCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return this.buscarTodosClientes();
	}
	
	@GetMapping("/buscarClienteParteNome/{nome}")
	public List<Cliente> buscarParteNome(@PathVariable(value = "nome") String nome) {
		return clienteRepository.findByParteNome(nome);
	}
	
	@GetMapping("/buscarClienteNomeEmail/{nome}/{email}")
	public List<Cliente> buscarNomeEmail(@PathVariable(value = "nome") String nome,
										 @PathVariable(value = "email") String email) {
		return clienteRepository.findByNomeEmail(nome, email);
	}
}
