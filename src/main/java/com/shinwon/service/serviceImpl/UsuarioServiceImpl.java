package com.shinwon.service.serviceImpl;

import com.shinwon.model.Usuario;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.repo.IUsuarioRepo;
import com.shinwon.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService {

    @Autowired
    private IUsuarioRepo repo;
    @Override
    protected IGenericRepo<Usuario, Integer> getRepo() {
        return repo;
    }
}
