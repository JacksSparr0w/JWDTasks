package com.katsubo.saver;

import com.katsubo.exception.SaverException;

import java.util.List;

@FunctionalInterface
public interface Saver<T> {
    public void save(List<T> data, String fileName) throws SaverException;
}
