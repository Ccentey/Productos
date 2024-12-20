/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Poductos.service;

import com.example.Poductos.modelo.producto;
import java.io.FileOutputStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@RestController
@RequestMapping("/reportes")

public class ReporteExcelService {
    
public void generarReporte(List<producto> productos, OutputStream outputStream) throws IOException {
    // Crear un libro de Excel
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Reporte de Productos");

    // Crear fila de encabezado
    Row headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("ID");
    headerRow.createCell(1).setCellValue("Nombre");
    headerRow.createCell(2).setCellValue("Categoría");
    headerRow.createCell(3).setCellValue("Cantidad");
    headerRow.createCell(4).setCellValue("Precio");
    headerRow.createCell(5).setCellValue("Estado");

    // Llenar los datos
    int rowNum = 1;
    for (producto producto : productos) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(producto.getIdproducto());
        row.createCell(1).setCellValue(producto.getNombre());
        row.createCell(2).setCellValue(producto.getIdcategoria());
        row.createCell(3).setCellValue(producto.getCantidad());
        row.createCell(4).setCellValue(producto.getPrecio());
        row.createCell(5).setCellValue(producto.getEstado());
    }

    // Escribir el archivo Excel en el OutputStream
    workbook.write(outputStream);

    // Cerrar recursos
    workbook.close();
}

}
