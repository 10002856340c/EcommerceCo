package com.deg.clientservice.model;

import java.time.LocalDate;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int dni;
   @Column
    private String nombre;
  @Column
    private String apellido;
  @Column
    private LocalDate fecha_nacimiento;
}
