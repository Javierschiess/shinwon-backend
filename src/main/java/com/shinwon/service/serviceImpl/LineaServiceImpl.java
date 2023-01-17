package com.shinwon.service.serviceImpl;

import com.shinwon.model.Linea;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.repo.ILineaRepo;
import com.shinwon.service.ILineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LineaServiceImpl extends CRUDImpl<Linea, Integer>  implements ILineaService {

    @Autowired
    private ILineaRepo repo;

    @Override
    protected IGenericRepo<Linea, Integer> getRepo() {
        return repo;
    }

    @Override
    public Linea registrarLinea(Linea linea) throws Exception {

        linea.setEstado(true);
        linea.setFechaRegistro(LocalDateTime.now());
        return repo.save(linea);
    }
}
