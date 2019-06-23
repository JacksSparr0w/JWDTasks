package com.katsubo.task4.thread;


import com.katsubo.task4.entity.Matrix;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Changer implements Runnable {
    private final static Logger log = LogManager.getLogger(Changer.class);
    private final int value;
    private Matrix matrix;

    public Changer(Matrix matrix, int value) {
        this.matrix = matrix;
        this.value = value;
        log.log(Level.INFO, "new thread created");
    }

    public void run() {
        for (int i = 0; i < matrix.getSize(); i++) {
            if (matrix.getElementValue(i, i) == 0) {
                matrix.setElement(i, i, value);
                log.log(Level.INFO, "Element " + i + " is initialized by " + value);
                System.out.println(matrix.toString());
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    log.log(Level.ERROR, e.getMessage());
                }
            }
        }
    }
}
