package com.shinwon.service.serviceImpl;

import com.shinwon.model.Bodega;
import com.shinwon.repo.IBodegaRepo;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.service.IBodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BodegaServiceImpl extends CRUDImpl<Bodega, Integer> implements IBodegaService {

    @Autowired
    private IBodegaRepo repo;

    @Override
    protected IGenericRepo<Bodega, Integer> getRepo() {
        return repo;
    }

    @Override
    public Bodega registrarBodega(Bodega bodega) throws Exception {

        bodega.setEstado(true);
        bodega.setFechaRegistro(LocalDateTime.now());
        return repo.save(bodega);
    }

    @Override
    public Page<Bodega> findPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

}
