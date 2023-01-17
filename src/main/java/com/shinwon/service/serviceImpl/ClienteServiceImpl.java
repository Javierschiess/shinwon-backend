package com.shinwon.service.serviceImpl;

import com.shinwon.model.Cliente;
import com.shinwon.repo.IClienteRepo;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

    @Autowired
    private IClienteRepo repo;

    @Override
    protected IGenericRepo<Cliente, Integer> getRepo() {
        return repo;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {

        cliente.setEstado(true);
        cliente.setFechaRegistro(LocalDateTime.now());
        return repo.save(cliente);
    }
}
