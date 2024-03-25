package com.killerbee.awpag.apiController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.killerbee.awpag.domain.model.Cliente;
import com.killerbee.awpag.domain.repository.ClienteRepository;
import com.killerbee.awpag.domain.service.CadastroClienteService;

import jakarta.validation.Valid;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private final CadastroClienteService cadastroClienteService;
	private final ClienteRepository clienteRepository;
	
	public ClienteController(ClienteRepository clietClienteRepository,CadastroClienteService cadastroClienteService) {
		this.clienteRepository=clietClienteRepository;
		this.cadastroClienteService=cadastroClienteService;
	}
	//@PersistenceContext
	//private EntityManager manager;
	
	@GetMapping 
	public List<Cliente> Listar() {
		
		//return clienteRepository.findById(2);
		return clienteRepository.findAll();
		
		//return manager.createQuery("from Cliente",Cliente.class)			.getResultList();
	}
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> Buscar(@PathVariable Long clienteId) {
		Optional<Cliente>cliente= clienteRepository.findById(clienteId);	
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();		
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Cliente Adicionar(@Valid @RequestBody Cliente cliente) {
		
		return cadastroClienteService.Salvar(cliente);
		
	}
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> Atualizar(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
		cliente=clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> Excluir(@PathVariable Long clienteId) {
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteRepository.deleteById(clienteId);
		return ResponseEntity.noContent().build();
		
	}
	
	

}
