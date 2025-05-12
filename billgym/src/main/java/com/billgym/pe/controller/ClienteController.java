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

import com.billgym.pe.entity.Cliente;
import com.billgym.pe.exeption.DniDuplicadoExeption;
import com.billgym.pe.service.ClienteService;

@Controller
public class ClienteController {

    private final ClienteService clienteService;
	
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;	
	}
	//LISTAR CLIENTE
	@GetMapping("/clientes")
	public String obtenerCliente(Model model) {
		List<Cliente> clientes =clienteService.listarClientes();
		model.addAttribute("clientes",clientes);
		return "clientes";
		
	}
	//EDITAR CLIENTE
	@GetMapping("/clientes/edit/{id}")
	public String editarCliente(@PathVariable("id")Integer id, Model model) {
		Cliente cliente = clienteService.obtenerCliente(id);
		model.addAttribute("cliente",cliente);
		return"editarCliente";
	}
	
	//ACTUALIZAR CLIENTE
	@PostMapping("/clientes/actualizar")
	public String actualizarCliente(@ModelAttribute("cliente") Cliente cliente, RedirectAttributes redirectAttributes) {
		
		try {
			clienteService.guardarCliente(cliente);
			redirectAttributes.addFlashAttribute("mensaje", "Cliente actualizado Correctamente :");
			return "redirect:/clientes";
		} catch (DniDuplicadoExeption e) {
			redirectAttributes.addFlashAttribute("errorDni", e.getMessage());
			return"redirect:/clientes/edit/"+cliente.getId();
		}
		
	}
	
	//CREAR CLIENTE
	@GetMapping("/clientes/agregar")
	public String agregarCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return"crearCliente";
	}
	
	//GUARDAR CLIENTE
	@PostMapping("/clientes/guardar")
	public String guardaCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {
		try {
			clienteService.guardarCliente(cliente);
			return"redirect:/clientes";
		} catch (DniDuplicadoExeption e) {
			model.addAttribute( "errorDni",e.getMessage());
			model.addAttribute("cliente", cliente);
			return "crearCliente";
		}
		
	}
	
	//ELIMINAR CLIENTE
	@GetMapping("/clientes/eliminar/{id}")
	public String eliminarCliente(@PathVariable("id") Integer id) {
		clienteService.eliminarCliente(id);
		return"redirect:/clientes";
	}
	
	//BUSCAR CLIENTE POR SU DNI
	@GetMapping("/clientes/buscar")
	 public String buscarCliente(@RequestParam("buscar")String terminoBusqueda, Model model) {
		 List<Cliente> resultados = clienteService.buscar(terminoBusqueda);
		 model.addAttribute("clientes",resultados);
		 return"clientes";
	 }


}
