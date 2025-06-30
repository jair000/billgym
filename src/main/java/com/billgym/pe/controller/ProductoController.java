package com.billgym.pe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.billgym.pe.entity.Loguin;
import com.billgym.pe.entity.Producto;
import com.billgym.pe.entity.RolUsuario;
import com.billgym.pe.service.ProductosService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductoController {

    private final ProductosService productosService;

    public ProductoController(ProductosService productosService) {
        this.productosService = productosService;
    }

    // Validación común para todos los métodos
    private boolean accesoPermitido(HttpSession session, RolUsuario... rolesPermitidos) {
        Object usuarioObj = session.getAttribute("usuarioLogueado");
        if (usuarioObj == null) return false;

        Loguin usuario = (Loguin) usuarioObj;
        RolUsuario rol = usuario.getUsuarioDato().getRol();

        for (RolUsuario rolPermitido : rolesPermitidos) {
            if (rol == rolPermitido) {
                return true;
            }
        }
        return false;
    }

    // LISTAR PRODUCTO
    @GetMapping("/productos")
    public String obtenerProducto(Model model, HttpSession session, HttpServletResponse response) {
        if (!accesoPermitido(session, RolUsuario.PRESIDENTE_FUNDADOR, RolUsuario.GERENTE_OPRACIONES)) {
            return "redirect:/home";
        }
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        List<Producto> productos = productosService.listarProducto();
        model.addAttribute("productos", productos);
        return "productos";
    }

    // EDITAR PRODUCTO
    @GetMapping("/productos/edit/{id_producto}")
    public String editarProducto(@PathVariable("id_producto") Integer id_producto, Model model,
                                 HttpSession session, HttpServletResponse response) {
        if (!accesoPermitido(session, RolUsuario.PRESIDENTE_FUNDADOR)) {
            return "redirect:/home";
        }
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        Producto producto = productosService.obtenerProducto(id_producto);
        model.addAttribute("producto", producto);
        return "editarProducto";
    }

    // ACTUALIZAR PRODUCTO
    @PostMapping("/productos/actualizar")
    public String actualizaProducto(@ModelAttribute("producto") Producto producto,
                                    RedirectAttributes redirectAttributes,
                                    HttpSession session) {
        if (!accesoPermitido(session, RolUsuario.PRESIDENTE_FUNDADOR)) {
            return "redirect:/home";
        }
        productosService.guardarproducto(producto);
        redirectAttributes.addFlashAttribute("mensaje", "Producto actualizado correctamente");
        return "redirect:/productos";
    }

    // CREAR PRODUCTO
    @GetMapping("/productos/crear")
    public String crearProducto(Model model, HttpSession session, HttpServletResponse response) {
        if (!accesoPermitido(session, RolUsuario.PRESIDENTE_FUNDADOR)) {
            return "redirect:/home";
        }
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        model.addAttribute("producto", new Producto());
        return "crearProducto";
    }

    // GUARDAR PRODUCTO
    @PostMapping("/productos/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto,
                                  RedirectAttributes redirectAttributes,
                                  HttpSession session) {
        if (!accesoPermitido(session, RolUsuario.PRESIDENTE_FUNDADOR)) {
            return "redirect:/home";
        }
        productosService.guardarproducto(producto);
        redirectAttributes.addFlashAttribute("mensaje", "Producto guardado correctamente");
        return "redirect:/productos";
    }

    // ELIMINAR PRODUCTO
    @GetMapping("/productos/eliminar/{id_producto}")
    public String eliminarProducto(@PathVariable("id_producto") Integer id_producto,
                                   HttpSession session) {
        if (!accesoPermitido(session, RolUsuario.PRESIDENTE_FUNDADOR)) {
            return "redirect:/home";
        }
        productosService.eliminarProducto(id_producto);
        return "redirect:/productos";
    }

    // BUSCAR PRODUCTO
    @GetMapping("/productos/buscar")
    public String buscarProducto(@RequestParam("buscar") String terminoBusqueda, Model model,
                                 HttpSession session, HttpServletResponse response) {
        if (!accesoPermitido(session, RolUsuario.PRESIDENTE_FUNDADOR, RolUsuario.GERENTE_OPRACIONES)) {
            return "redirect:/home";
        }
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        List<Producto> resultado = productosService.buscar(terminoBusqueda);
        model.addAttribute("productos", resultado);
        return "productos";
    }
}
