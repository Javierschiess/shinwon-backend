package com.shinwon.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {

    private Integer idEmpleado;

    //@JsonIncludeProperties(value = {"puesto"})
    private PuestoDTO puesto;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 50)
    private String nombres;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 50)
    private String apellidos;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 75)
    private String direccion;

    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 15)
    private String sexo;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 12)
    private String telefono;

    private Boolean estado;

    @NotNull
    private LocalDate fechaIngreso;
}
