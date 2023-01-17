package com.shinwon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "direccion", nullable = false, length = 75)
    private String direccion;

    @Column(name = "email")
    private String email;

    @Column(name = "sexo", nullable = false, length = 15)
    private String sexo;

    @Column(name = "telefono",nullable = false, length = 12)
    private String telefono;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @CreationTimestamp
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_puesto", nullable = false, foreignKey = @ForeignKey(name = "FK_empleado_puesto"))
    private Puesto puesto;





}
