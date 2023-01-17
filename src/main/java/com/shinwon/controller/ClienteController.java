package com.shinwon.controller;

import com.shinwon.dto.ClienteDTO;
import com.shinwon.model.Cliente;
import com.shinwon.service.IClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteDTO> registrar(@RequestBody ClienteDTO dto)throws Exception{
        Cliente client = service.registrarCliente(mapper.map(dto, Cliente.class));
        return new ResponseEntity<>(mapper.map(client, ClienteDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> modificar(@RequestBody ClienteDTO dto)throws Exception{
        Cliente client = service.modificar(mapper.map(dto, Cliente.class));
        return new ResponseEntity<>(mapper.map(client, ClienteDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar()throws Exception{
        List<ClienteDTO> lista = service.listar().stream().map(x -> mapper.map(x, ClienteDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id)throws Exception{
        Cliente client = service.listarPorId(id);
        return new ResponseEntity<>(client, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(Integer id)throws Exception{
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
