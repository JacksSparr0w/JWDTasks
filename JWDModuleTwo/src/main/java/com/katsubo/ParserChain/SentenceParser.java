package com.katsubo.ParserChain;

import com.katsubo.composite.CompositeComponent;
import com.katsubo.composite.LeafComponent;
import com.katsubo.entity.Sentence;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SentenceParser extends Parser {
    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);
    private static final String DELIMETER_SENTENCE_BY_WORDS = "\\s";

    @Override
    public LeafComponent parseLine(String line) {

        List<String> stringWords = new LinkedList<>(Arrays.asList(line.split(DELIMETER_SENTENCE_BY_WORDS)));
        CompositeComponent sentence = new Sentence();
        for (String stringWord : stringWords) {
            LeafComponent word = nextParse(stringWord.trim());
            sentence.addComponent(word);
            LOGGER.log(Level.INFO, "Add new word to sentence");

        }
        return sentence;
    }
}
