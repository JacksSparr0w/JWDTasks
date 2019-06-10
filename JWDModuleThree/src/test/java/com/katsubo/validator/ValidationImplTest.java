package com.katsubo.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidationImplTest {
    private static final String schemaName = "src/test/resources/data.xsd";

    private static final String validFile = "src/test/resources/data.xml";
    private static final String invalidFile = "src/test/resources/invalidData.xml";

    Validation validation;

    @Before
    public void prepare(){
        validation = new ValidationImpl();
    }

    @Test
    public void successTest(){
        boolean actual = validation.isValid(validFile, schemaName);
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void unsuccessTest(){
        boolean actual = validation.isValid(invalidFile, schemaName);
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

}