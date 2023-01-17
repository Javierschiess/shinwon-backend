package com.shinwon.controller;

import com.shinwon.dto.PuestoDTO;
import com.shinwon.model.Puesto;
import com.shinwon.service.IPuestoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/puestos")
public class PuestoController {

    @Autowired
    private IPuestoService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<PuestoDTO> registrar(@Validated @RequestBody PuestoDTO dto)throws Exception{
        Puesto puesto = service.registrarPuesto(mapper.map(dto, Puesto.class));
        return new ResponseEntity<>(mapper.map(puesto, PuestoDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PuestoDTO> modificar(@Validated @RequestBody PuestoDTO dto)throws Exception{
        Puesto puesto = service.modificar(mapper.map(dto, Puesto.class));
        return new ResponseEntity<>(mapper.map(puesto, PuestoDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PuestoDTO>> listar()throws Exception{
        List<PuestoDTO> lista = service.listar().stream().map(x -> mapper.map(x, PuestoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Puesto> listarPorId(@PathVariable("id") Integer id)throws Exception{
        Puesto puest = service.listarPorId(id);
        return new ResponseEntity<>(puest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
