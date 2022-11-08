
package com.deg.clientservice.model;


import java.time.LocalDateTime;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "venta")

public class VentaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha_alta;
    private double total;
   @ManyToOne
  @JoinColumn(name = "cliente_id")
   private Client clienteid;
    
    
}
