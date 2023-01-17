package com.shinwon.controller;

import com.shinwon.dto.EmpleadoDTO;
import com.shinwon.model.Empleado;
import com.shinwon.service.IEmpleadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<EmpleadoDTO> registrar(@Validated @RequestBody EmpleadoDTO dto)throws Exception{
        Empleado empleado = service.registrarEmpleado(mapper.map(dto, Empleado.class));
        return new ResponseEntity<>(mapper.map(empleado, EmpleadoDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EmpleadoDTO> modificar(@Validated @RequestBody EmpleadoDTO dto)throws Exception{
        Empleado empleado = service.modificar(mapper.map(dto, Empleado.class));
        return new ResponseEntity<>(mapper.map(empleado, EmpleadoDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> listar ()throws Exception{
        List<EmpleadoDTO> lista = service.listar().stream().map(x -> mapper.map(x, EmpleadoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> listarPorId(@PathVariable("id") Integer id)throws Exception{
        Empleado empl = service.listarPorId(id);
        return new ResponseEntity<>(empl, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(Integer id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
