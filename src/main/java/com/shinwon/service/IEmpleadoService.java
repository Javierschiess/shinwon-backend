package com.shinwon.service;

import com.shinwon.model.Empleado;

public interface IEmpleadoService extends ICRUD<Empleado, Integer> {

    Empleado registrarEmpleado(Empleado empleado)throws Exception;

}
