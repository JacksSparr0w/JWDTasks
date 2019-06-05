package com.katsubo.ParserChain;

public interface ParserChain<T> {
    T parseLine(String line);

    ParserChain<T> linkWidth(ParserChain<T> next);
}
