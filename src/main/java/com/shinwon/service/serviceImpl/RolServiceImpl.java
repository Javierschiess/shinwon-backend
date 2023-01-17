package com.shinwon.service.serviceImpl;

import com.shinwon.model.Rol;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.repo.IRolRepo;
import com.shinwon.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends CRUDImpl<Rol, Integer> implements IRolService {

   @Autowired
    private IRolRepo repo;
    @Override
    protected IGenericRepo<Rol, Integer> getRepo() {
        return repo;
    }

}
