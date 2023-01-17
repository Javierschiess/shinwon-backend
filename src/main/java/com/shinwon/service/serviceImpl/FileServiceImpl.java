package com.shinwon.service.serviceImpl;

import com.shinwon.model.File;
import com.shinwon.repo.IDetalleFileRepo;
import com.shinwon.repo.IFileRepo;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FileServiceImpl extends CRUDImpl<File, Integer>  implements IFileService {

    @Autowired
    private IFileRepo repo;

    @Autowired
    private IDetalleFileRepo detalleRepo;

    @Override
    protected IGenericRepo<File, Integer> getRepo() {
        return repo;
    }

    @Override
    public File registrarFile(File file) throws Exception {
        file.getDetalleFile().forEach(det -> det.setFile(file));
        file.setEstado(true);
        file.setFechaRegistro(LocalDateTime.now());
        file.getDetalleFile().forEach(det -> det.setFechaRegistro(LocalDateTime.now()));
        file.getDetalleFile().forEach(det -> det.setEstado(true));
        return repo.save(file);
    }

}
