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

import com.billgym.pe.entity.Loguin;
import com.billgym.pe.service.LoguinService;


									//FALTA HTML
@Controller
public class LoguinController {
	// CONSTRUCTOR 
    private final LoguinService loguinService;
	
	public LoguinController(LoguinService loguinService) {
		this.loguinService = loguinService;		
	}
	
	//METODO PARA LISTAR USER LOGUIN
	@GetMapping("/login")
	public String obtenerLoguin(Model model) {
		List<Loguin> loguin = loguinService.listarLoguin();
		model.addAttribute("longin",loguin);
		return"loguin";
	}
	
	//EDITAR LOGUIN
	@GetMapping("/login/edit/{id_loguin}")
	public String editarLoguin(@PathVariable("id_loguin")Integer id_loguin, Model model) {
		Loguin loguin = loguinService.obtenerLoguin(id_loguin);
		model.addAttribute("login",loguin);
		return"editarLogin";
	}
	
	// ACTUALIZAR LOGUIN
	@PostMapping("/login/actualizar")
	public String actualizarLoguin(@ModelAttribute("id_loguin")Loguin loguin, RedirectAttributes redirectAttributes) {
		loguinService.guardarLoguin(loguin);
		redirectAttributes.addFlashAttribute("mensaje","loguinactualizada correctamente");
		return"redirect:/login";
	}
	
	
	//CREAR LOGUIN
	@GetMapping("/login/crear")
	public String crearLoguin(Model model) {
		model.addAttribute("login", new Loguin());
		return"crearLoguin";
	}
	
	//GUARDAR LOGUIN
	@PostMapping("/login/guardar")
	public String guardarLoguin(@ModelAttribute("loguin")Loguin loguin,RedirectAttributes redirectAttributes) {
		loguinService.guardarLoguin(loguin);
		redirectAttributes.addFlashAttribute("mensaje","Loguin User guardado correctamente :");
		return"redirect:/login";
	}
	
	//ELIMINAR LOGUIN
	@GetMapping("/login/eliminar/{id_loguin}")
	public String eliminarLoguin(@PathVariable("id_loguin")Integer id_loguin) {
		loguinService.eliminar(id_loguin);
		return"redirect:/login";
	}
	
	//BUSCAR USER LOGUIN POR DNI
	@GetMapping("/login/buscar")
	public String buscarUsuarioPorDni(@RequestParam("buscar")String terminoBusqueda, Model model) {
		List<Loguin> resultados = loguinService.buscar(terminoBusqueda);
		model.addAttribute("loguin",resultados);
		return"login";
	}

}
