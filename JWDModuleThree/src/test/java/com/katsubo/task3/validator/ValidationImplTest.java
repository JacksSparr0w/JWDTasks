package com.katsubo.task3.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidationImplTest {
    private static String schemaName;


    private static String validFile;
    private static String invalidFile;

    Validation validation;

    @Before
    public void prepare(){
        schemaName = ValidationImplTest.class.getResource("/data.xsd").getFile();
        validFile = ValidationImplTest.class.getResource("/data.xml").getFile();
        invalidFile = ValidationImplTest.class.getResource("/invalidData").getFile();
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