
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
@Column(name = "fecha_alta")
    private LocalDateTime fechaalta;
    private double total;
   @ManyToOne
  @JoinColumn(name = "cliente_id")
   private ClienteModel clienteid;
    
    
}
