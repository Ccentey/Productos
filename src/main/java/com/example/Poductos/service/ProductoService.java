/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Poductos.service;

import com.example.Poductos.modelo.producto;
import com.example.Poductos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")

public class ProductoService {
   
    @Autowired
    private ProductoRepository productoRepository;

    public List<producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<producto> obtenerPorId(int id) {
        return productoRepository.findById(id);
    }

    public producto guardar(producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminar(int id) {
        productoRepository.deleteById(id);
    }
}
