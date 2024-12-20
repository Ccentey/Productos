/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Poductos.service;

import com.example.Poductos.modelo.producto;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ReportePdfService {
    
   public void generarReporte(List<producto> productos, OutputStream outputStream) throws DocumentException {
    // Crear el documento PDF
    Document document = new Document();
    PdfWriter.getInstance(document, outputStream);
    document.open();

    // Agregar contenido al PDF (título, tabla, etc.)
    document.add(new Paragraph("Reporte de Productos"));
    PdfPTable table = new PdfPTable(5); // Cambia el número de columnas según tu modelo
    table.addCell("ID");
    table.addCell("Nombre");
    table.addCell("Categoría");
    table.addCell("Cantidad");
    table.addCell("Precio");

    for (producto p : productos) {
        table.addCell(String.valueOf(p.getIdproducto()));
        table.addCell(p.getNombre());
        table.addCell(String.valueOf(p.getIdcategoria()));
        table.addCell(String.valueOf(p.getCantidad()));
        table.addCell(String.valueOf(p.getPrecio()));
    }

    document.add(table);
    document.close();
}

    
}
