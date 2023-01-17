package com.shinwon.controller;

import com.shinwon.dto.UsuarioDTO;
import com.shinwon.model.Usuario;
import com.shinwon.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<UsuarioDTO> registrar(@Validated @RequestBody UsuarioDTO dto)throws Exception{
        Usuario usuario = service.registrar(mapper.map(dto, Usuario.class));
        return new ResponseEntity<>(mapper.map(usuario, UsuarioDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> modificar(@Validated @RequestBody UsuarioDTO dto)throws Exception{
        Usuario usuario = service.modificar(mapper.map(dto, Usuario.class));
        return new ResponseEntity<>(mapper.map(usuario, UsuarioDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar ()throws Exception{
        List<UsuarioDTO> lista = service.listar()
                    .stream()
                    .map(x -> mapper.map(x, UsuarioDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId (@PathVariable("id") Integer id)throws Exception{
        Usuario usuar = service.listarPorId(id);
        return new ResponseEntity<>(usuar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
