package com.shinwon.controller;

import com.shinwon.service.IBodegaService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BodegaController.class)
public class BodegaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IBodegaService service;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void listar()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/bodegas")
                .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }



}
