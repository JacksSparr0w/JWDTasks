package com.katsubo.builder;

import com.katsubo.bean.Device;

import java.util.ArrayList;
import java.util.List;

public abstract class Builder {
    protected List<Device> devices = new ArrayList<Device>();


    public List<Device> getDevices() {
        return devices;
    }

    public abstract void buildDevices(String fileName);

}
