package com.shinwon.service;

import com.shinwon.model.Linea;

public interface ILineaService extends ICRUD<Linea, Integer> {

    Linea registrarLinea(Linea linea)throws Exception;

}
