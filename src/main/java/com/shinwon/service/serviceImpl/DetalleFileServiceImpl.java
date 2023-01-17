package com.shinwon.service.serviceImpl;

import com.shinwon.model.DetalleFile;
import com.shinwon.repo.IDetalleFileRepo;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.service.IDetalleFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleFileServiceImpl extends CRUDImpl<DetalleFile, Integer> implements IDetalleFileService {

    @Autowired
    private IDetalleFileRepo repo;

    @Override
    protected IGenericRepo<DetalleFile, Integer> getRepo() {
        return repo;
    }

    @Override
    public DetalleFile registrarDetalleFile(DetalleFile detalleFile) throws Exception {

        return repo.save(detalleFile);
    }
}
