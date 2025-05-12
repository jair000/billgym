package com.billgym.pe.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
	// Ruta principal
		@GetMapping("/")
		public String mostrarHome(Model model) {
			model.addAttribute("mensaje", "desde controller");
			return "home";
		}
		
		@GetMapping("/sobreNosotros")
		public String mostrarSobreNosotros(Model model) {
			model.addAttribute("mensaje", "desde controller sobre Nosotros");
			return"sobreNosotros";
		}

}
