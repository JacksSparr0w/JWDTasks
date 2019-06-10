package com.katsubo.test;

import com.katsubo.bean.Port;
import com.katsubo.builder.Builder;
import com.katsubo.builder.StAXBuilder;

public class Test {
    public static void main(String[] args) {
        Port port = Port.of("com").get();
        System.out.println(port);

        Builder builder = new StAXBuilder();
        try {
            System.out.println("start");
            builder.buildDevices("src/test/resources/data.xml");
            System.out.println("finish");
            System.out.println(builder.getDevices());
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
