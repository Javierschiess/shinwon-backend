package com.shinwon.controller;

import com.shinwon.dto.RolDTO;
import com.shinwon.model.Rol;
import com.shinwon.service.IRolService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<RolDTO> registrar(@Validated @RequestBody RolDTO dto)throws Exception{
        Rol rol = service.registrar(mapper.map(dto, Rol.class));
        return new ResponseEntity<>(mapper.map(rol, RolDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<RolDTO> moficiar(@Validated @RequestBody RolDTO dto)throws Exception{
        Rol rol = service.modificar(mapper.map(dto, Rol.class));
        return new ResponseEntity<>(mapper.map(rol, RolDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listar()throws Exception{
        List<RolDTO> lista = service.listar().stream().map(x -> mapper.map(x, RolDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> listarPorId(@PathVariable("id") Integer id)throws Exception{
        Rol ro = service.listarPorId(id);
        return new ResponseEntity<>(ro, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
