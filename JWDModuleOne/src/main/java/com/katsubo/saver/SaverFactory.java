package com.katsubo.saver;

public class SaverFactory {
    public static Saver getSaver(SaverType type){
        Saver saver = null;
        switch (type){
            case SAVER_TXT:
                saver = new DataSaver();
                break;
            default:
                break;
        }
        return saver;
    }
}
