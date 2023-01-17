package com.shinwon.service.serviceImpl;

import com.shinwon.model.Color;
import com.shinwon.repo.IColorRepo;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ColorServiceImpl extends CRUDImpl<Color, Integer> implements IColorService {

    @Autowired
    private IColorRepo repo;

    @Override
    protected IGenericRepo<Color, Integer> getRepo() {
        return repo;
    }

    @Override
    public Color registrarColor(Color color) throws Exception {

        color.setEstado(true);
        color.setFechaRegistro(LocalDateTime.now());
        return repo.save(color);
    }
}
