package com.katsubo.parser;

public abstract class ParserFactory {
    public static Parser getParser(ParserType parserType){
        Parser parser = null;
        switch (parserType){
            case PARSER_TXT:
                parser = new TextParser();
                break;
        }
        return parser;
    }
}
