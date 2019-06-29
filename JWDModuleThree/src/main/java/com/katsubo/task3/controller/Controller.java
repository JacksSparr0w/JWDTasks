package com.katsubo.task3.controller;

import java.util.List;

public interface Controller<T> {
    void parseFile(String builderName);
    List<T> getBeans();
}