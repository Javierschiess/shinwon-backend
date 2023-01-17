package com.shinwon.service.serviceImpl;

import com.shinwon.model.Talla;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.repo.ITallaRepo;
import com.shinwon.service.ITallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TallaServiceImpl extends CRUDImpl<Talla, Integer> implements ITallaService {

    @Autowired
    private ITallaRepo repo;

    @Override
    protected IGenericRepo<Talla, Integer> getRepo() {
        return repo;
    }

    @Override
    public Talla registrarTalla(Talla talla) throws Exception {

        talla.setEstado(true);
        talla.setFechaRegistro(LocalDateTime.now());
        return repo.save(talla);
    }
}
