package com.katsubo.task4.thread;

import com.katsubo.task4.entity.Element;
import com.katsubo.task4.entity.Matrix;
import com.katsubo.task4.reader.Reader;
import com.katsubo.task4.reader.ReaderException;
import com.katsubo.task4.reader.ReaderImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Runner {
    private final static Logger log = LogManager.getLogger(Runner.class);
    private static final String fileName = "src/main/resources/data.txt";
    private static int size = 7;
    private static int m = 6;

    public static void main(String[] arg) {
        Element[][] elements = new Element[size][size];
        Random random = new Random();
        Matrix matrix;

        Reader reader = new ReaderImpl();
        try {
            elements = reader.read(fileName);
        } catch (ReaderException e) {
            log.log(Level.ERROR, e.getMessage());
        }

        /*
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    elements[i][j] = new Element(0);
                } else {
                    elements[i][j] = new Element(random.nextInt(89) + 10);
                }
            }
        }
        */

        matrix = new Matrix(elements);

        /*
        List<Runnable> changers = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            changers.set(i, new Changer(matrix, i + 1));
        }

        List<Thread> threads = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            threads.set(i, new Thread(changers.get(i)));
        }

        for (int i = 0; i < m; i++){
            threads.get(i).start();
        }
        */

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
        System.out.println("================");
        System.out.println(matrix.toString());
        System.out.println("================");


    }
}
