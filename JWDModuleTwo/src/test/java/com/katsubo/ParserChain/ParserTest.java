package com.katsubo.ParserChain;

import com.katsubo.composite.CompositeComponent;
import com.katsubo.composite.LeafComponent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {
    private ParserChain<LeafComponent> parserChain;

    @Before
    public void prepareParserChain() {
        parserChain = new WordParser()
                .linkWidth(new SentenceParser())
                .linkWidth(new ParagraphParser())
                .linkWidth(new TextParser());
    }

    @Test
    public void successTest() {
        String lines = "\tIt has survived not only five centuries, but also the leap into electronic& " +
                "typesetting, remaining essentially unchanged. It was popularised in the with the& " +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with& " +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.& " +
                "\tIt is a long established fact that a reader will be distracted by the readable& " +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a& " +
                "more-or-less normal distribution of letters, as opposed to using 'Content here, content& " +
                "here', making it look like readable English.& " +
                "\tIt is a established fact that a reader will be of a page when looking at its& " +
                "layout.& " +
                "\tBye.";

        CompositeComponent text = (CompositeComponent) parserChain.parseLine(lines);
        String actual = text.getContent();

        String expected = "\tIt has survived not only five centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\n" +
                "more-or-less normal distribution of letters, as opposed to using 'Content here, content\n" +
                "here', making it look like readable English.\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its\n" +
                "layout.\n" +
                "\tBye.";
        Assert.assertEquals(expected, actual);
    }
}