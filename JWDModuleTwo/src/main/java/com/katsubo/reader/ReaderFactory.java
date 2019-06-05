package com.katsubo.reader;

public class ReaderFactory {
    public static Reader getReader(ReaderType parserType){
        Reader reader = null;
        switch (parserType){
            case FILE_READER:
                reader = new FileReader();
                break;
        }
        return reader;
    }
}
