/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deg.clientservice.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class ProductosModel {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String sku;

      private String descripcion;

      @Column(name = "precio_compra")
      private double precioCompra;

      @Column(name = "precio_venta")
      private double precioVenta;
     
      private int stock;
      
      private LocalDate fecha_alta;
    
}
