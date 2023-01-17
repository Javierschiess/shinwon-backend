package com.shinwon.service;

import com.shinwon.model.DetalleFile;

public interface IDetalleFileService extends ICRUD<DetalleFile, Integer> {

    DetalleFile registrarDetalleFile (DetalleFile detalleFile)throws Exception;
}
