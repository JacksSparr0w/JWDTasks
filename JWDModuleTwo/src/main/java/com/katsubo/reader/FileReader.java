package com.katsubo.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Reader {
    private static final String NEW_LINE_DELIMETER = "& ";
    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);

    @Override
    public String readFile(String fileName) throws ReaderException {
        List<String> lines = new ArrayList<>();
        LOGGER.log(Level.INFO, "Reading file");
        try {
            lines = Files.readAllLines(Paths.get(fileName), Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new ReaderException("No such file!");
        }

        return String.join(NEW_LINE_DELIMETER, lines);
    }
}
