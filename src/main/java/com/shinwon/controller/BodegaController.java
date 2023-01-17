package com.shinwon.controller;

import com.shinwon.dto.BodegaDTO;
import com.shinwon.model.Bodega;
import com.shinwon.service.IBodegaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    @Autowired
    private IBodegaService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<BodegaDTO> registrar(@Validated @RequestBody BodegaDTO dto)throws Exception{
        Bodega bodega = service.registrarBodega(mapper.map(dto, Bodega.class));
        return new ResponseEntity<>(mapper.map(bodega, BodegaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BodegaDTO> modificar(@Validated @RequestBody BodegaDTO dto)throws Exception{
        Bodega bodega = service.modificar(mapper.map(dto, Bodega.class));
        return new ResponseEntity<>(mapper.map(bodega, BodegaDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BodegaDTO>> listar ()throws Exception{
        List<BodegaDTO> lista = service.listar().stream()
                .map(bodega -> this.mapper.map(bodega, BodegaDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bodega> listarPorId(@PathVariable("id") Integer id)throws Exception{
        Bodega bod = service.listarPorId(id);
        return new ResponseEntity<>(bod, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(Integer id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Bodega>> findPage(@RequestParam(value = "pages", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "10") int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Bodega> pageResponse = service.findPage(pageRequest);

        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }
}
