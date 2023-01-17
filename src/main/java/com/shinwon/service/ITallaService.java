package com.shinwon.service;

import com.shinwon.model.Talla;

public interface ITallaService extends ICRUD<Talla, Integer> {

    Talla registrarTalla(Talla talla)throws Exception;

}
