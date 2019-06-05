package com.katsubo.ParserChain;

import com.katsubo.composite.LeafComponent;
import com.katsubo.entity.Word;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordParser extends Parser {
    private static final Logger LOGGER = LogManager.getLogger(WordParser.class);
    private static final String WORD = "[\\w-]+";
    private static final String CHARS_AFTER = "(?<=\\w)\\W+$";
    private static final String CHARS_BEFORE = "^\\W+(?=\\w)";

    @Override
    public LeafComponent parseLine(String line) {
        String stringWord = find(WORD, line);
        String charBefore = find(CHARS_BEFORE, line);
        String charAfter = find(CHARS_AFTER, line);

        LeafComponent word = new Word(stringWord, charBefore, charAfter);
        LOGGER.log(Level.INFO, "Create new word");


        return word;
    }

    private String find(String regex, String line) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        String stringWord = "";
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            stringWord = line.substring(start, end);
        }
        return stringWord;
    }
}
