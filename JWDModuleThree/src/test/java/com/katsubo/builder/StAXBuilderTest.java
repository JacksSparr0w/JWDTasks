package com.katsubo.builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StAXBuilderTest {
    Builder builder;

    @Before
    public void prepare() {
        builder = new SAXBuilder();
        try {
            builder.buildDevices("src/test/resources/data.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successTest() {
        String actual = builder.getDevices().toString();

        String expected = "[Device {1 Mouse a4tech us 99 Type {mouse false 5 false IO_DEVICE [USB]} false}, " +
                "Device {2 keyboard razer us 199 Type {keyboard true 25 true IO_DEVICE [COM]} true}]";


        Assert.assertEquals(expected, actual);
        Assert.assertEquals(actual, expected);
    }
}