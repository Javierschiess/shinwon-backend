package com.shinwon.service;

import com.shinwon.model.Puesto;

public interface IPuestoService extends ICRUD<Puesto, Integer> {

    Puesto registrarPuesto(Puesto puesto)throws Exception;

}
