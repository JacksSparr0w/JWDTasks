package com.katsubo.task3.dao;

import com.katsubo.task3.bean.Device;

import java.util.List;

public class DaoImpl implements Dao<Device> {
    private static Dao instance = new DaoImpl();
    List<Device> devices;

    public static Dao getInstance(){
        return instance;
    }

    public void set(List<Device> devices) {
        this.devices = devices;
    }

    public List<Device> get() {
        return devices;
    }
}
