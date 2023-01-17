package com.shinwon.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PuestoDTO {

    private Integer idPuesto;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 25)
    private String puesto;

    @Size(min = 10, max = 150)
    private String descripcion;

    private Boolean estado;

}
