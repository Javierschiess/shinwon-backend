package com.shinwon.controller;

import com.shinwon.dto.ColorDTO;
import com.shinwon.model.Color;
import com.shinwon.service.IColorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/colores")
public class ColorController {

    @Autowired
    private IColorService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<ColorDTO> registrar(@RequestBody ColorDTO dto)throws Exception{
        Color color = service.registrarColor(mapper.map(dto, Color.class));
        return new ResponseEntity<>(mapper.map(color, ColorDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ColorDTO> modificar(@RequestBody ColorDTO dto)throws Exception{
        Color color = service.modificar(mapper.map(dto, Color.class));
        return new ResponseEntity<>(mapper.map(color, ColorDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ColorDTO>> listar()throws Exception{
        List<ColorDTO> lista = service.listar().stream().map(x -> mapper.map(x, ColorDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> listarPorId(@PathVariable("id") Integer id)throws Exception{
        Color col = service.listarPorId(id);
        return new ResponseEntity<>(col, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar (Integer id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
