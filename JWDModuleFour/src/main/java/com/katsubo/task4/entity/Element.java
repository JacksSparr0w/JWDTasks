package com.katsubo.task4.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Element {
    private final static Logger log = LogManager.getLogger(Element.class);
    int value;
    Lock lock;

    public Element(int value) {
        this.value = value;
        lock = new ReentrantLock();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        lock.lock();
        try {
            int oldValue = this.value;
            this.value = value;
            log.log(Level.INFO, "Value has changed by " + oldValue + " to " + this.value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
