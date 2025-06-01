package com.billgym.pe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.billgym.pe.entity.Loguin;

@Controller
public class InicioController {
	
	@GetMapping("/")
	public String mostrarInicio(Model model) {
		model.addAttribute("loguin", new Loguin());
		return"redirect:/login";
		
	}

}
