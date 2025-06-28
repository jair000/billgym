package com.billgym.pe.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.billgym.pe.entity.Compras;
import com.billgym.pe.repository.ComprasRepository;

@Service
public class ComprasService {

    private final ComprasRepository comprasRepository;
	
	public ComprasService(ComprasRepository comprasRepository) {
		this.comprasRepository = comprasRepository;		
	}	
	
	
	//PARA DEVOLVER TODA LA LISTA DEL COMPRAS
	public List<Compras> listarcompra(){
		return comprasRepository.findAll();
	}
	
	//PARA OBTENER COMPRAS POR ID
	
	public Compras obtenerCompras(Integer id_compras) {
		return comprasRepository.findById(id_compras).orElseThrow(()-> new IllegalArgumentException("ID Invalido: "+ id_compras));
				
	}
	
	//METODO PARA ACTUALIZAR COMPRAS
	public void guardaCompras(Compras compras) {		
		comprasRepository.save(compras);	
		
	}
	//PARA BUSCAR COMPRAS POR PRODUCTO
	public List<Compras> buscar (String termino){
		return comprasRepository.buscarPorNombreProducto(termino);
	}
	
	//METODO PARA ELIMINAR COMPRAS
	public void eliminarCompras(Integer id_compras) {
		
		comprasRepository.deleteById(id_compras);
		
	}

}
