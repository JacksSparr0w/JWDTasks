package com.katsubo.task4.reader;

import com.katsubo.task4.entity.Element;

public interface Reader {
    Element[][] read(String filename) throws ReaderException;
}
