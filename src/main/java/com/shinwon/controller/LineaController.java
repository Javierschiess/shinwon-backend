package com.shinwon.controller;

import com.shinwon.dto.LineaDTO;
import com.shinwon.model.Linea;
import com.shinwon.service.ILineaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lineas")
public class LineaController {

    @Autowired
    private ILineaService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<LineaDTO> registrar(@Validated @RequestBody LineaDTO dto)throws Exception{
        Linea linea = service.registrarLinea(mapper.map(dto, Linea.class));
        return new ResponseEntity<>(mapper.map(linea, LineaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LineaDTO> modificar(@Validated @RequestBody LineaDTO dto)throws Exception{
        Linea linea = service.modificar(mapper.map(dto, Linea.class));
        return new ResponseEntity<>(mapper.map(linea, LineaDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LineaDTO>> listar ()throws Exception{
        List<LineaDTO> lista = service.listar().stream()
                .map(linea -> this.mapper.map(linea, LineaDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Linea> listarPorId(@PathVariable("id") Integer id)throws Exception{
        Linea lin = service.listarPorId(id);
        return new ResponseEntity<>(lin, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(Integer id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
