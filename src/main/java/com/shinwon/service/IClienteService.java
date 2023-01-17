package com.shinwon.service;

import com.shinwon.model.Cliente;

public interface IClienteService extends ICRUD<Cliente, Integer> {

    Cliente registrarCliente(Cliente cliente)throws Exception;
}
