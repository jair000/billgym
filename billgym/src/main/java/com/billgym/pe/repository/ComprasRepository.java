package com.billgym.pe.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.billgym.pe.entity.Compras;

public interface ComprasRepository extends JpaRepository<Compras, Integer>{	
	 @Query("SELECT c FROM Compras c JOIN c.producto p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
	List<Compras> buscarPorNombreProducto(@Param("nombre") String producto);
}
