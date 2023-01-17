package com.shinwon.service.serviceImpl;

import com.shinwon.model.Empleado;
import com.shinwon.repo.IEmpleadoRepo;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmpleadoServiceImpl extends CRUDImpl<Empleado, Integer> implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepo repo;

    @Override
    protected IGenericRepo<Empleado, Integer> getRepo() {
        return repo;
    }

    @Override
    public Empleado registrarEmpleado(Empleado empleado) throws Exception {

        empleado.setEstado(true);
        empleado.setFechaRegistro(LocalDateTime.now());
        return repo.save(empleado);
    }
}
