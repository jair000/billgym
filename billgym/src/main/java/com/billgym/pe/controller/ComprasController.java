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

import com.billgym.pe.entity.Compras;
import com.billgym.pe.entity.Producto;
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
		List<Compras> compras = comprasService.listarcompra();
		model.addAttribute("compras", compras);
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
	@PostMapping("/compras/actualizar")
	public String actualizaCompras(@ModelAttribute("compras") Compras compras, RedirectAttributes redirectAttributes) {
		comprasService.guardaCompras(compras);
		redirectAttributes.addFlashAttribute("mensaje"," 'Compras Actualizado correctamente: '");
		return"redirect:/compras";
	}
	
	
	//CREAR COMPRAS
	@GetMapping("/compras/crear")
	public String crearCompras(Model model) {
		model.addAttribute("compra", new Compras());
		return"crearCompra";
	}
	
	//GUARDAR COMPRAS
	@PostMapping("/compras/guardar")
	public String guardarCompras(@ModelAttribute("compra") Compras compras,RedirectAttributes redirectAttributes) {
		comprasService.guardaCompras(compras);
		redirectAttributes.addFlashAttribute("mensaje", " Compras guardado con exito");
		return"redirect:/compras";
	}
	
	
	//ELIMINAR COMPRAS
	@GetMapping("/compras/eliminar/{id_compras}")
	public String eliminaCompras(@PathVariable("id_compras")Integer id_compras ) {
		comprasService.eliminarCompras(id_compras);
		return"redirect:/compras";
	}
	
	//BUSCAR COMPRAS POR PRODUCTO
	@GetMapping("/compras/buscar")
	public String buscarComprasPorProducto(@RequestParam("buscar")String terminoBusqueda, Model model ) {
		List<Compras> resultados = comprasService.buscar(terminoBusqueda);
		model.addAttribute("compras", resultados);
		return"compras";
	}

}
