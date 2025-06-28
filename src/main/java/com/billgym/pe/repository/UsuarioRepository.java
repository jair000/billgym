package com.billgym.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billgym.pe.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	//BUSCADOR POR DATOS
	List<Usuario>findByDniContainingIgnoreCase(String dni);
}
