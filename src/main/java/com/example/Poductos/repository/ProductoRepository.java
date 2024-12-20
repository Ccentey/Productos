/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Poductos.repository;

import com.example.Poductos.modelo.producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author PelayoYoler
 */
public  interface  ProductoRepository extends JpaRepository<producto, Integer>  {
    
}
