package com.shinwon.controller;

import com.shinwon.dto.TallaDTO;
import com.shinwon.model.Talla;
import com.shinwon.service.ITallaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tallas")
public class TallaController {

    @Autowired
    private ITallaService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<TallaDTO> registrar(@Validated @RequestBody TallaDTO dto)throws Exception{
        Talla talla = service.registrarTalla(mapper.map(dto, Talla.class));
        return new ResponseEntity<>(mapper.map(talla, TallaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TallaDTO> modificar(@Validated @RequestBody TallaDTO dto)throws Exception{
        Talla talla = service.modificar(mapper.map(dto, Talla.class));
        return new ResponseEntity<>(mapper.map(talla, TallaDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TallaDTO>> listar()throws Exception{
        List<TallaDTO> lista = service.listar().stream().map(x -> mapper.map(x, TallaDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talla> listarPorId(@PathVariable("id") Integer id)throws Exception{
        Talla tall = service.listarPorId(id);
        return new ResponseEntity<>(tall, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
