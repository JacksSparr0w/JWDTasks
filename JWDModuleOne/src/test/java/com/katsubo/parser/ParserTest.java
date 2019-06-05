package com.katsubo.parser;

import com.katsubo.bean.BeanFactory;
import com.katsubo.bean.Toy;
import com.katsubo.exception.ParserException;
import com.katsubo.validation.ValidationFactory;
import com.katsubo.validation.ValidationType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.katsubo.bean.Color.*;
import static com.katsubo.bean.Material.*;
import static com.katsubo.bean.Type.*;

public class ParserTest {
    Parser parser;

    @Before
    public void prepare(){
        parser = ParserFactory.getParser(ParserType.PARSER_TXT);
        parser.setValidation(ValidationFactory.getValidation(ValidationType.TOY));
    }

    @Test
    public void successParse() throws ParserException {
        List<String> lines = new ArrayList<>();
        lines.add("BIG_CAR RED GLASS 3 6 250");
        lines.add("BALL BLUE RUBBER 3 9 100");
        lines.add("DOLL BLUE RUBBER 0 6 1000");
        lines.add("CAR BLUE RUBBER 1 4 321");

        List<Toy> actual = parser.parse(lines);
        List<Toy> expected = new ArrayList<>();
        expected.add(BeanFactory.getToy(BIG_CAR, RED, GLASS, 3, 6, 250));
        expected.add(BeanFactory.getToy(BALL, BLUE, RUBBER, 3, 9, 100));
        expected.add(BeanFactory.getToy(DOLL, BLUE, RUBBER, 0, 6, 1000));
        expected.add(BeanFactory.getToy(CAR, BLUE, RUBBER, 1, 4, 321));

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = ParserException.class)
    public void throwException() throws ParserException {
        List<String> lines = new ArrayList<>();
        lines.add("BIG_CAR noColor GLASS 3 6 250");
        lines.add("BALL BLU_U RUBBER 3 9 100");
        lines.add("DOLL BLUE noMaterial 0 6 1000");
        lines.add("CAR BLUE  1 4 321");

        List<Toy> actual = parser.parse(lines);
        List<Toy> expected = new ArrayList<>();
        expected.add(BeanFactory.getToy(BIG_CAR, RED, GLASS, 3, 6, 250));
        expected.add(BeanFactory.getToy(BALL, BLUE, RUBBER, 3, 9, 100));
        expected.add(BeanFactory.getToy(DOLL, BLUE, RUBBER, 0, 6, 1000));
        expected.add(BeanFactory.getToy(CAR, BLUE, RUBBER, 1, 4, 321));

        Assert.assertEquals(expected, actual);
    }
}