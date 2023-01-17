package com.shinwon.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProduccionDTO {

    private Integer idProduccion;

    private int producido;

    private int restante;

    private int porcentaje;

    private int diasHabiles;

    private int horasHabiles;

    private BodegaDTO bodega;

    private LineaDTO linea;

    private FileDTO file;

    private DetalleFileDTO detalleFile;

    private TallaDTO talla;

    private ColorDTO color;

    @Min(1)
    @NotNull
    private int cantidad;

    private LocalDateTime hora;

}
