package com.katsubo.ParserChain;

import com.katsubo.composite.CompositeComponent;
import com.katsubo.composite.LeafComponent;
import com.katsubo.entity.Paragraph;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParagraphParser extends Parser {
    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class);
    private static final String DELIMETER_PARAGRAPH_BY_SENTENCES = "(?<=[.!?(!?)])\\s";


    @Override
    public LeafComponent parseLine(String line) {
        List<String> stringSentences = new LinkedList<>(Arrays.asList(line.split(DELIMETER_PARAGRAPH_BY_SENTENCES)));
        CompositeComponent paragraph = new Paragraph();
        for (String stringSentence : stringSentences) {
            CompositeComponent sentence = (CompositeComponent) nextParse(stringSentence.trim());
            paragraph.addComponent(sentence);
            LOGGER.log(Level.INFO, "Add new sentence to paragraph");

        }
        return paragraph;
    }
}
