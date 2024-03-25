package com.killerbee.awpag.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.killerbee.awpag.domain.model.Cliente;
import com.killerbee.awpag.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public CadastroClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository=clienteRepository;
	}
	
	
	@Transactional
	public Cliente Salvar(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}
	

}
