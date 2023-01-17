package com.shinwon.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.shinwon.model.Color;
import com.shinwon.model.Talla;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class DetalleFileDTO {

    private Integer idDetalleFile;

    @JsonBackReference
    private FileDTO file;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 25)
    private String po;

    private LocalDate fechaInicioProdu;

    private LocalDate fechaExpo;

    private Long cantPiezas;

    private Boolean estado;

    @NotNull
    //@JsonIncludeProperties(value = {"bodega", "ubicacion", "encargado"})
    private BodegaDTO bodega;

    @NotNull
    //@JsonIncludeProperties(value = {"linea","encargado"})
    private LineaDTO linea;

    @NotNull
    //@JsonIncludeProperties(value = {"color"})
    private ColorDTO color;

    @NotNull
    //@JsonIncludeProperties(value = {"talla"})
    private TallaDTO talla;


}
