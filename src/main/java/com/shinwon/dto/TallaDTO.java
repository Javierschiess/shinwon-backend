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
public class TallaDTO {

    private Integer idTalla;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 5)
    private String talla;

    @Size(min = 10, max = 150)
    private String descripcion;

    private Boolean estado;


}
