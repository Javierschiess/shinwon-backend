package com.shinwon.service;

import com.shinwon.model.Color;

public interface IColorService extends ICRUD<Color, Integer> {

    Color registrarColor(Color color) throws Exception;
}
