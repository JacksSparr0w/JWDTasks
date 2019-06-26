package com.katsubo.task4.thread;

import com.katsubo.task4.entity.Element;
import com.katsubo.task4.entity.Matrix;
import com.katsubo.task4.reader.Reader;
import com.katsubo.task4.reader.ReaderException;
import com.katsubo.task4.reader.ReaderImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Runner {
    private final static Logger log = LogManager.getLogger(Runner.class);
    private static final String fileName = "src/main/resources/data.txt";
    private static int size = 7;

    public static void main(String[] arg) {
        Element[][] elements = new Element[size][size];
        Matrix matrix;

        Reader reader = new ReaderImpl();
        try {
            elements = reader.read(fileName);
        } catch (ReaderException e) {
            log.log(Level.ERROR, e.getMessage());
        }

        matrix = new Matrix(elements);

        Runnable changer1 = new Changer(matrix, 1);
        Runnable changer2 = new Changer(matrix, 2);
        Runnable changer3 = new Changer(matrix, 3);
        Runnable changer4 = new Changer(matrix, 4);

        Thread thread1 = new Thread(changer1);
        Thread thread2 = new Thread(changer2);
        Thread thread3 = new Thread(changer3);
        Thread thread4 = new Thread(changer4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            log.log(Level.ERROR, e.getMessage());
        }

    }
}
