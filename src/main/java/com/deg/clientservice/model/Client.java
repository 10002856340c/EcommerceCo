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

    private String dni;

    private String nombre;

    private String apellido;
  @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
}
