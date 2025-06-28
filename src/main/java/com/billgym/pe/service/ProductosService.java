package com.billgym.pe.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.billgym.pe.entity.Producto;
import com.billgym.pe.repository.ProductosRepository;

@Service
public class ProductosService {

    private final ProductosRepository productosRepository;

    ProductosService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }
	
    //LSISTA QUE DEBUELVE A LOS PRODUCTOS
    public List<Producto> listarProducto(){
    	return productosRepository.findAll();    	
    }
    
    //PARA ONTENER PRODUCTO POR ID
    public Producto obtenerProducto(Integer id_producto) {
    	return productosRepository.findById(id_producto).orElseThrow(()-> new IllegalArgumentException(" ID Invalido :"+id_producto));    	
    }
    
    //METODO PARA ELIMINAR 
    public void eliminarProducto(Integer id_producto) {
		productosRepository.deleteById(id_producto);
	}
    
    //METODOD PARA ACTUALIZAR PRODUCTO
    public void guardarproducto(Producto producto) {
    	productosRepository.save(producto);
    }
    
    //METODO PARA BUSCAR PRODUCTO
    
    public List<Producto> buscar (String termino){
    	return productosRepository.findByNombreContainingIgnoreCase(termino);
    }
    
   
	
}
