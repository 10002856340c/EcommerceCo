
package com.deg.clientservice.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
/*
@Data
@Entity
@Table(name = "detalle_venta")
public class DetalleVentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    @Column(name = "subtotal")
    private double total;

  @ManyToOne
  @JoinColumn(name = "venta_id")
   private int ventaid;


}
*/