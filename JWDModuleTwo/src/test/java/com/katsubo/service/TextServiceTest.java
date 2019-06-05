package com.katsubo.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TextServiceTest {
    Service service;

    @Before
    public void prepare() {
        service = ServiceFactory.getInstance(ServiceType.TEXT_SERVICE);
    }

    @After
    public void clean() {
    }

    @Test
    public void sort() {
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

        service.read();
        service.sort();
        String actual = service.collect();

        Assert.assertEquals(expected, actual);
    }

}