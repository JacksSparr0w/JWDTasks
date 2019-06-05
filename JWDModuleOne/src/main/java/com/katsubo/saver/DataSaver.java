package com.katsubo.saver;

import com.katsubo.bean.Toy;
import com.katsubo.exception.SaverException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataSaver implements Saver<Toy>{
    private static final Logger logger = LogManager.getLogger(DataSaver.class);
    @Override
    public void save(List<Toy> data, String fileName) throws SaverException {
        try{
            List<String> lines = new ArrayList<>();
            for (Toy toy : data)
                lines.add(toy.toString());
            Files.createFile(Paths.get(fileName));
            Files.write(Paths.get(fileName), lines, Charset.forName("UTF-8"));
            logger.log(Level.INFO, "Write is complete");
        }
        catch (IOException e){
            logger.log(Level.ERROR, e.getMessage());
            throw new SaverException("Error writing to file");
        }
    }
}
