package com.shinwon.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {

    private Integer idFile;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 25)
    private String file;

    @Size(min = 5, max = 150)
    private String descripcion;

    private Boolean estado;

    //@JsonIncludeProperties(value = {"cliente", "pais"})
    private ClienteDTO cliente;

    @JsonManagedReference
    private List<DetalleFileDTO> detalleFile;



}
