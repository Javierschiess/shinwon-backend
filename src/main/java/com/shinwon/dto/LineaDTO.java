package com.shinwon.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.shinwon.model.Empleado;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LineaDTO {

    private Integer idLinea;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer linea;

    @Size(min = 5, max = 150)
    private String descripcion;

    private Boolean estado;

    @JsonBackReference
    private BodegaDTO bodega;

    @NotNull
    //@JsonIncludeProperties(value = {"nombres", "apellidos", "puesto"})
    private EmpleadoDTO encargado;

}
