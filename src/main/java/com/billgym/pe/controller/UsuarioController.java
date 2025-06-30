package com.billgym.pe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.billgym.pe.entity.RolUsuario;
import com.billgym.pe.entity.Usuario;
import com.billgym.pe.exeption.DniDuplicadoExeption;
import com.billgym.pe.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public String obtenerUsuario(Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuarios", usuarioService.listarUsuario());
        model.addAttribute("rolUsuario", session.getAttribute("rolUsuario"));
        return "usuarios";
    }

    @GetMapping("/usuarios/edit/{id}")
    public String editarUsuario(@PathVariable("id") Integer id, Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuarioService.obtenerUsuario(id));
        return "editarUsuario";
    }

    @PostMapping("/usuarios/actualizar")
    public String actualizarUsuario(@ModelAttribute("usuario") Usuario usuario,
                                    RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }

        try {
            usuarioService.guardarUsuario(usuario);
            redirectAttributes.addFlashAttribute("mensaje", "Usuario Actualizado Correctamente :");
            return "redirect:/usuarios";
        } catch (DniDuplicadoExeption e) {
            redirectAttributes.addFlashAttribute("errorDni", e.getMessage());
            return "redirect:/usuarios/edit/" + usuario.getId();
        }
    }

    @GetMapping("/usuarios/crear")
    public String crearUsuario(Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", RolUsuario.values());
        return "crearUsuario";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }

        try {
            usuarioService.guardarUsuario(usuario);
            return "redirect:/usuarios";
        } catch (DniDuplicadoExeption e) {
            model.addAttribute("errorDni", e.getMessage());
            model.addAttribute("usuario", usuario);
            return "crearUsuario";
        }
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id, HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }

        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/buscar")
    public String buscarUsuario(@RequestParam("buscar") String terminoBusqueda,
                                Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }

        List<Usuario> resultados = usuarioService.buscar(terminoBusqueda);
        model.addAttribute("usuarios", resultados);
        return "usuarios";
    }
}
