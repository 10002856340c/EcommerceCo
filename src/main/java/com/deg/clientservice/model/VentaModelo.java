
package com.deg.clientservice.model;

import java.time.LocalDate;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "venta")
public class VentaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha_alta;
    private double total;
  @Column(name = "cliente_id")
   private int cliente_id;
    
    
}
