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

import jakarta.servlet.http.HttpSession;

@Controller
public class LoguinController {
	// CONSTRUCTOR
	private final LoguinService loguinService;

	public LoguinController(LoguinService loguinService) {
		this.loguinService = loguinService;
	}

	// METODO PARA LISTAR USER LOGUIN
	@GetMapping("/loguinTabla")
	public String obtenerLoguin(Model model) {
		List<Loguin> loguin = loguinService.listarLoguin();
		model.addAttribute("loguins", loguin);
		return "loginTabla";
	}

	// EDITAR LOGUIN
	@GetMapping("/loguinTabla/edit/{id_loguin}")
	public String editarLoguin(@PathVariable("id_loguin") Integer id_loguin, Model model) {
		Loguin loguin = loguinService.obtenerLoguin(id_loguin);
		model.addAttribute("loguin", loguin);
		return "editarLogin";
	}

	// ACTUALIZAR LOGUIN
	@PostMapping("/loguinTabla/actualizar")
	public String actualizarLoguin(@ModelAttribute("loguin") Loguin loguin, RedirectAttributes redirectAttributes) {
		loguinService.guardarLoguin(loguin);
		redirectAttributes.addFlashAttribute("mensaje", "loguinactualizada correctamente");
		return "redirect:/loguinTabla";
	}

	// CREAR LOGUIN
	@GetMapping("/loguinTabla/crear")
	public String crearLoguin(Model model) {
		model.addAttribute("loguin", new Loguin());
		return "crearLoguin";
	}

	// GUARDAR LOGUIN
	@PostMapping("/loguinTabla/guardar")
	public String guardarLoguin(@ModelAttribute("loguin") Loguin loguin, RedirectAttributes redirectAttributes) {
		loguinService.guardarLoguin(loguin);
		redirectAttributes.addFlashAttribute("mensaje", "Loguin User guardado correctamente :");
		return "redirect:/loguinTabla";
	}

	// ELIMINAR LOGUIN
	@GetMapping("/loguinTabla/eliminar/{id_loguin}")
	public String eliminarLoguin(@PathVariable("id_loguin") Integer id_loguin) {
		loguinService.eliminar(id_loguin);
		return "redirect:/loguinTabla";
	}

	// BUSCAR USER LOGUIN POR DNI
	@GetMapping("/loguinTabla/buscar")
	public String buscarUsuarioPorDni(@RequestParam("buscar") String terminoBusqueda, Model model) {
		List<Loguin> resultados = loguinService.buscar(terminoBusqueda);
		model.addAttribute("loguins", resultados);
		return "loguinTabla";
	}

	// PARA LOGUEARSE EL USUARIO
	@GetMapping("/login")
	public String mostrarFormularioLoguin(Model model, HttpSession session) {
		if(session.getAttribute("usuarioLogueado")!=null) {
			return"redirect:/home";
			
		}
		model.addAttribute("loguin", new Loguin());
		return "loginn";
	}

	// PARA VALIDAR Y GUARDAR SESION DE LOGUIN
	//FALTA IMPLEMENTAR
	
	
	

}
