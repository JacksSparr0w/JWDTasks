package com.katsubo.task3.service;

import java.util.List;

public interface Service<T> {
    //boolean checkFile(String fileName, String schemaName);

    void load(String fileName, String builderName);

    List<T> getBeans();
}
