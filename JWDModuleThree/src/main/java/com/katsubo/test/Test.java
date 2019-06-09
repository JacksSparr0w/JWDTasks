package com.katsubo.test;

import com.katsubo.bean.Port;
import com.katsubo.builder.Builder;
import com.katsubo.builder.SAXBuilder;

public class Test {
    public static void main(String[] args){
        Port port = Port.of("com").get();
        System.out.println(port);

        Builder builder = new SAXBuilder();
        try {
            System.out.println("start");
            builder.buildDevices();
            System.out.println("finish");
        } catch (Exception e){
            System.out.println("error");
        }
    }
}
