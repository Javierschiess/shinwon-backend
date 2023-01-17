package com.shinwon.service;

import com.shinwon.model.File;

public interface IFileService extends ICRUD<File, Integer> {

    File registrarFile(File file)throws Exception;
}
