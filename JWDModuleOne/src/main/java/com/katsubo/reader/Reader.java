package com.katsubo.reader;

import com.katsubo.exception.ReaderException;

import java.util.List;

@FunctionalInterface
public interface Reader {
    public List<String> read(String fileName) throws ReaderException;
}
