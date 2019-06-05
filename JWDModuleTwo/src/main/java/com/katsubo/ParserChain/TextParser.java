package com.katsubo.ParserChain;

import com.katsubo.composite.CompositeComponent;
import com.katsubo.composite.LeafComponent;
import com.katsubo.entity.Text;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TextParser extends Parser {
    private static final Logger LOGGER = LogManager.getLogger(TextParser.class);
    private static final String TEXT_DELIMETER_BY_PARAGRAPHS = "\\t";

    @Override
    public LeafComponent parseLine(String line) {
        List<String> stringParagraphs = new LinkedList<>(Arrays.asList(line.trim().split(TEXT_DELIMETER_BY_PARAGRAPHS)));
        CompositeComponent text = new Text();
        for (String stringParagraph : stringParagraphs) {
            CompositeComponent paragraph = (CompositeComponent) nextParse(stringParagraph.trim());
            text.addComponent(paragraph);
            LOGGER.log(Level.INFO, "Add new paragraph to text");
        }
        return text;
    }
}
