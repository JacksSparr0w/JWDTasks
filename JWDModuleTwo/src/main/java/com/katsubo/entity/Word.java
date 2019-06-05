package com.katsubo.entity;

import com.katsubo.composite.LeafComponent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Word implements LeafComponent {
    private static final Logger LOGGER = LogManager.getLogger(Word.class);
    private final String charBefore;
    private final String word;
    private final String charAfter;

    public Word(String word, String charBefore, String charAfter) {
        this.charBefore = charBefore;
        this.word = word;
        this.charAfter = charAfter;
    }

    public String getContent() {
        LOGGER.log(Level.INFO, "return word");
        return charBefore + word + charAfter;
    }
}
