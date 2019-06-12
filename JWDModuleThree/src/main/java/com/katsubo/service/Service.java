package com.katsubo.service;

import java.util.List;

public interface Service<T> {
    boolean checkFile(String fileName, String schemaName);

    void load(String fileName, String bulderName);

    List<T> get();
}
