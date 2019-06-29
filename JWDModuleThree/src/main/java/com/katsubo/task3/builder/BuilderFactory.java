package com.katsubo.task3.builder;

public abstract class BuilderFactory {
    public static Builder getInstance(String type){
        BuilderType builderType = BuilderType.of(type).orElse(BuilderType.DOM);
        Builder builder = null;
        switch (builderType){
            case DOM:
                builder = new DOMBuilder();
                break;
            case SAX:
                builder = new SAXBuilder();
                break;
            case StAX:
                builder = new StAXBuilder();
        }
        return builder;
    }
}
