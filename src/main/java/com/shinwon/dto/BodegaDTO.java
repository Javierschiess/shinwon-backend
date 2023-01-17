package com.shinwon.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shinwon.model.Empleado;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BodegaDTO {

    private Integer idBodega;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 15)
    private String bodega;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    private String ubicacion;

    @Size(min = 10, max = 150)
    private String descripcion;

    private Boolean estado;

    //@JsonIncludeProperties(value = {"nombres", "apellidos", "puesto"})
    private EmpleadoDTO encargado;

    @JsonManagedReference
    private List<LineaDTO> linea;
}
