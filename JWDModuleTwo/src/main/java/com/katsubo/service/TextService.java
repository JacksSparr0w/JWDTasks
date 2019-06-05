package com.katsubo.service;

import com.katsubo.ParserChain.*;
import com.katsubo.composite.CompositeComponent;
import com.katsubo.composite.LeafComponent;
import com.katsubo.dao.TextTreeDao;
import com.katsubo.reader.FileReader;
import com.katsubo.reader.Reader;
import com.katsubo.reader.ReaderException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class TextService implements Service {
    private static final Logger LOGGER = LogManager.getLogger(TextService.class);
    private static final String fileName = "src/main/resources/Text";
    private static Service instance = new TextService();
    private TextTreeDao textTree;

    private TextService() {

    }

    public static Service getInstance() {
        return instance;
    }

    @Override
    public void sort() {
        LOGGER.log(Level.INFO, "Start sort");
        List<LeafComponent> paragraphs = ((CompositeComponent) textTree.getRoot()).getComponents();
        for (LeafComponent paragraph : paragraphs) {
            LOGGER.log(Level.INFO, "sort new paragraph");
            ((CompositeComponent) paragraph).getComponents().sort((t1, t2) -> {
                int sizeOft1 = ((CompositeComponent) t1).getCountOfLeafs();
                int sizeOft2 = ((CompositeComponent) t2).getCountOfLeafs();
                return sizeOft1 - sizeOft2;

            });
        }
    }

    @Override
    public void read() {
        LOGGER.log(Level.INFO, "Read file");
        Reader reader = new FileReader();
        try {
            String stringText = reader.readFile(fileName);
            LOGGER.log(Level.INFO, "Read file successfull");
            ParserChain<LeafComponent> componentParser = new WordParser()
                    .linkWidth(new SentenceParser())
                    .linkWidth(new ParagraphParser())
                    .linkWidth(new TextParser());
            LeafComponent text = componentParser.parseLine(stringText);
            textTree = new TextTreeDao(text);
        } catch (ReaderException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public String collect() {
        LOGGER.log(Level.INFO, "Collect composite");
        String stringText = textTree.getAllTree();
        return stringText;
    }

}
