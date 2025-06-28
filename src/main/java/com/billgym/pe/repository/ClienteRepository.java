package com.billgym.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billgym.pe.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	List<Cliente>findByDniContainingIgnoreCase(String dni);

}
