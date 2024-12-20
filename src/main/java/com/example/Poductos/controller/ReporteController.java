/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Poductos.controller;

import com.example.Poductos.modelo.producto;
import com.example.Poductos.service.ProductoService;
import com.example.Poductos.service.ReporteExcelService;
import com.example.Poductos.service.ReportePdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private ReporteExcelService reporteExcelService;
    @Autowired
    private ReportePdfService reportePdfService;

    @GetMapping("/pdf")
    public void generarReportePdf(HttpServletResponse response) {
    try {
        // Configurar los encabezados para la descarga
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=productos_report.pdf");
        
        // Obtener los productos y generar el reporte directamente en el flujo de salida
        List<producto> productos = productoService.obtenerTodos();
        reportePdfService.generarReporte(productos, response.getOutputStream());
        
        // Cerrar el flujo de salida
        response.getOutputStream().flush();
    } catch (DocumentException | IOException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al generar el reporte PDF");
    }
    }
    
@GetMapping("/excel")
public void descargarReporte(HttpServletResponse response) throws IOException {
    // Configura la respuesta para indicar que se está devolviendo un archivo Excel
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setHeader("Content-Disposition", "attachment; filename=productos_report.xlsx");

    // Obtiene la lista de productos y genera el reporte
    List<producto> productos = productoService.obtenerTodos();
    reporteExcelService.generarReporte(productos, response.getOutputStream());
}

}