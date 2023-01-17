package com.shinwon.service.serviceImpl;

import com.shinwon.model.Puesto;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.repo.IPuestoRepo;
import com.shinwon.service.IPuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PuestoServiceImpl extends CRUDImpl<Puesto, Integer> implements IPuestoService {

    @Autowired
    private IPuestoRepo repo;

    @Override
    protected IGenericRepo<Puesto, Integer> getRepo() {
        return repo;
    }

    @Override
    public Puesto registrarPuesto(Puesto puesto) throws Exception {

        puesto.setEstado(true);
        puesto.setFechaRegistro(LocalDateTime.now());
        return repo.save(puesto);
    }
}
