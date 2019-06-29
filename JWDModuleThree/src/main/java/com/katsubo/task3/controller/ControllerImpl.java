package com.katsubo.task3.controller;

import com.katsubo.task3.bean.Device;
import com.katsubo.task3.service.DeviceService;
import com.katsubo.task3.service.Service;

import java.util.List;

public class ControllerImpl implements Controller<Device> {
    private static final String fileName = ControllerImpl.class.getResource("/data.xml").getFile();

    private static Controller instance = new ControllerImpl();
    private final Service service = DeviceService.getInstance();

    public static Controller getInstance() {
        return instance;
    }

    @Override
    public void parseFile(String builderName) {
        service.load(fileName, builderName);
    }

    @Override
    public List<Device> getBeans() {
        return service.getBeans();
    }

}
