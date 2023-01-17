package com.shinwon.controller;

import com.shinwon.dto.ProduccionDTO;
import com.shinwon.model.Produccion;
import com.shinwon.service.IProduccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producciones")
public class ProduccionController {

    @Autowired
    private IProduccionService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<ProduccionDTO> registrar(@Validated @RequestBody ProduccionDTO dto)throws Exception{
        Produccion produccion = service.registrarProduccion(mapper.map(dto, Produccion.class));
        return new ResponseEntity<>(mapper.map(produccion, ProduccionDTO.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProduccionDTO>> listar ()throws Exception{
        List<ProduccionDTO> lista = service.listar().stream()
                .map(produccion -> this.mapper.map(produccion, ProduccionDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
