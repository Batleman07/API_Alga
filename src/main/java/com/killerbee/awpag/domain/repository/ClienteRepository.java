package com.killerbee.awpag.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.killerbee.awpag.domain.model.Cliente;
@Repository
public interface ClienteRepository extends  JpaRepository<Cliente,Long>{
	List<Cliente> findByNome(String nome);
	
}
