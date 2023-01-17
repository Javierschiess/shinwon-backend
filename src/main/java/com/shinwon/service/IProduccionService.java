package com.shinwon.service;

import com.shinwon.model.Produccion;

public interface IProduccionService extends ICRUD<Produccion, Long> {

    Produccion registrarProduccion(Produccion produccion)throws Exception;
}
