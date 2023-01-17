package com.shinwon.service;

import com.shinwon.model.Bodega;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBodegaService extends ICRUD<Bodega, Integer> {

    Bodega registrarBodega(Bodega bodega)throws Exception;

    Page<Bodega> findPage(Pageable pageable);

}
