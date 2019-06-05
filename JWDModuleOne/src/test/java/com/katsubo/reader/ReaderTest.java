package com.katsubo.reader;

import com.katsubo.exception.ReaderException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReaderTest {
    private static final String validPathAndFile = "src/main/resources/data_files/ValidData.txt";
    private static final String invalidPath = "../../data_files/InvalidData";

    private Reader reader;

    @Before
    public void prepare(){
        reader = ReaderFactory.getReader(ReaderType.FILE_READER);
    }

    @Test
    public void successTest() throws ReaderException {
        List<String> actual = reader.read(validPathAndFile);
        
        List<String> expected = new ArrayList<>();
        expected.add("BIG_CAR RED GLASS 3 6 250");
        expected.add("BALL BLUE RUBBER 3 9 100");
        expected.add("DOLL BLUE RUBBER 0 6 1000");
        expected.add("CAR BLUE RUBBER 1 4 321");

        Assert.assertEquals(expected, actual);

    }

    @Test(expected = ReaderException.class)
    public void unSuccessTest() throws ReaderException {
        List<String> actual = reader.read(invalidPath);
    }

}