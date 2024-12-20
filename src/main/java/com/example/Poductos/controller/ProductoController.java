/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Poductos.controller;

import com.example.Poductos.modelo.producto;
import com.example.Poductos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/productos")

public class ProductoController {
    
      @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listarProductos(Model model) {
        List<producto> productos = productoService.obtenerTodos();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new producto()); // Para crear un nuevo producto
        return "index"; // Retorna el nombre de la vista Thymeleaf
    }

    @PostMapping
    public String guardarProducto(@ModelAttribute producto producto) {
        productoService.guardar(producto);
        return "redirect:/productos"; // Redirige a la lista de productos
    }

    @PostMapping("/{id}")
    public String eliminarProducto(@PathVariable int id) {
        productoService.eliminar(id);
        return "redirect:/productos"; // Redirige a la lista de productos después de eliminar
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable int id, Model model) {
        producto producto = productoService.obtenerPorId(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        model.addAttribute("producto", producto);
        return "index"; // El formulario de edición usará el mismo formulario de agregar
    }
}
