package com.billgym.pe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.billgym.pe.entity.Producto;
import com.billgym.pe.service.ProductosService;

@Controller
public class ProductoController {

    private final ProductosService productosService;
	
	
	//CONSTRUCTOR
	public ProductoController(ProductosService productosService) {
		this.productosService = productosService;		
	}
	
	//LISTAR PRODUCTO
	@GetMapping("/productos")
	public String obtenerProducto(Model model) {
		List<Producto> productos = productosService.listarProducto();
		model.addAttribute("productos",productos);
		return"productos";		
		}
	
	//EDITAR PRODUCTO
	@GetMapping("/productos/edit/{id_producto}")
	public String editarProducto(@PathVariable("id_producto")
		Integer id_producto, Model model) {
		Producto producto = productosService.obtenerProducto(id_producto);
		model.addAttribute("producto",producto);
		return "editarProducto";
	}
	
	//PARA ACTUALIZAR PRODUCTO
	@PostMapping("/productos/actualizar")
	public String actualizaProducto(@ModelAttribute("producto")Producto producto, RedirectAttributes redirectAttributes) {
		productosService.guardarproducto(producto);
		redirectAttributes.addFlashAttribute("mensaje","´Producto actualizado Correctamente");
		return"redirect:/productos";
	}
	
	//CREAR PROdUCTO
	@GetMapping("/productos/crear")
	public String crearProducto(Model model) {
		model.addAttribute("producto",new Producto());
		return"crearProducto";
		
	}
	
	//PARA GUARDAR PRODUCTOS
	@PostMapping("/productos/guardar")
	public String guardarProducto(@ModelAttribute("producto") Producto producto,RedirectAttributes redirectAttributes) {
		productosService.guardarproducto(producto);
		redirectAttributes.addFlashAttribute("mensaje"," Producto Guardado Correctamente");
		return"redirect:/productos";
		
	}
	
	
	
	//METODO PARA ELIMINAR
	@GetMapping("productos/eliminar/{id_producto}")
	public String eliminarProducto(@PathVariable("id_producto")Integer id_producto) {
		productosService.eliminarProducto(id_producto);
		return"redirect:/productos";
	             
		
	}
	
	//BUSCAR PRODUCTO POR SU NOMBRE
	@GetMapping("/productos/buscar")
	public String buscarProducto(@RequestParam("buscar")String terminoBusqueda, Model model) {
		List<Producto> resultado = productosService.buscar(terminoBusqueda);
		model.addAttribute("productos",resultado);
		return "productos";
	}
	
}
