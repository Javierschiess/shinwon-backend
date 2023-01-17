package com.shinwon.controller;

import com.shinwon.dto.FileDTO;
import com.shinwon.model.File;
import com.shinwon.service.IFileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private IFileService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<FileDTO> registrar(@Validated @RequestBody FileDTO dto)throws Exception{
        File file = service.registrarFile(mapper.map(dto, File.class));
        return new ResponseEntity<>(mapper.map(file, FileDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FileDTO> modificar(@Validated @RequestBody FileDTO dto)throws Exception{
        File file = service.modificar(mapper.map(dto, File.class));
        return new ResponseEntity<>(mapper.map(file, FileDTO.class), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FileDTO>> listar ()throws Exception{
        List<FileDTO> lista = service.listar().stream()
                .map(det -> this.mapper.map(det, FileDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<File> listarPorId(@PathVariable("id") Integer id)throws Exception{
        File fil = service.listarPorId(id);
        return new ResponseEntity<>(fil, HttpStatus.OK);
    }
}
