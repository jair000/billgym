package com.billgym.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billgym.pe.entity.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {
	List<Producto>findByNombreContainingIgnoreCase(String nombre);
	Producto findByNombre(String nombre);

}
