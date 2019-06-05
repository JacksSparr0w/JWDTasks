package com.katsubo.reader;

@FunctionalInterface
public interface Reader {
    String readFile(String fileName) throws ReaderException;
}
