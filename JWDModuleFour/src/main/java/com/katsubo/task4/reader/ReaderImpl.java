package com.katsubo.task4.reader;

import com.katsubo.task4.entity.Element;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    private static final Logger LOGGER = LogManager.getLogger(ReaderImpl.class);

    @Override
    public Element[][] read(String fileName) throws ReaderException {
        int size;
        Element[][] elements;
        List<String> lines = new ArrayList<>();
        LOGGER.log(Level.INFO, "Reading file");
        try {
            lines = Files.readAllLines(Paths.get(fileName), Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new ReaderException("No such file!");
        }
        size = lines.size();
        elements = new Element[size][size];
        String[][] values = new String[size][size];
        for (int i = 0; i < size; i++) {
            values[i] = lines.get(i).trim().split(" ");
            for (int j = 0; j < size; j++) {
                elements[i][j] = new Element(Integer.valueOf(values[i][j]));
            }
        }

        return elements;
    }

}
