package com.billgym.pe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.billgym.pe.entity.Compras;
import com.billgym.pe.service.ComprasService;

@Controller
public class ComprasController {
													//FALTA HTML
    private final ComprasService comprasService;
	
	public ComprasController(ComprasService comprasService) {
		this.comprasService = comprasService;		
	}
	
	//LISTAR COMPRAS
	@GetMapping("/compras")
	public String obtenerCompras(Model model) {
		List<Compras> compra = comprasService.listarcompra();
		model.addAttribute("compra", compra);
		return"compras";
		
	}
	
	
	//EDITAR COMPRAS
	@GetMapping("/compras/edit/{id_compras}")
	public String editarCompra(@PathVariable("id_compras")Integer id_compras, Model model) {
		Compras compras = comprasService.obtenerCompras(id_compras);
		model.addAttribute("compra",compras);
		return"editarCompra";
	}
	
	
	//ACTUALIZAR COMPRAS
	public String actualizaCompras(@ModelAttribute("compras") Compras compras, RedirectAttributes redirectAttributes) {
		comprasService.guardaCompras(compras);
		redirectAttributes.addFlashAttribute("mensaje"," 'Compras Actualizado correctamente: '");
		return"redirect:/compras";
	}
	
	
	//CREAR COMPRAS
	
	//GUARDAR COMPRAS
	
	//ELIMINAR COMPRAS
	
	//BUSCAR COMPRAS POR PRODUCTO

}
