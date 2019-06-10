package com.katsubo.service;

import java.util.List;

public interface Service<T> {

    void load(String fileName, String bulderName);

    List<T> get();
}
