package com.katsubo.task3.builder;

import com.katsubo.task3.bean.Device;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Builder {
    private final static Logger log = LogManager.getLogger(Builder.class);

    protected List<Device> devices = new ArrayList<Device>();


    public List<Device> getDevices() {
        log.log(Level.INFO, "return devices");
        return devices;
    }

    public abstract void buildDevices(String fileName);

}
