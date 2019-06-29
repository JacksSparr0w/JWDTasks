package com.katsubo.task3.service;

import com.katsubo.task3.bean.Device;
import com.katsubo.task3.builder.Builder;
import com.katsubo.task3.builder.BuilderFactory;
import com.katsubo.task3.dao.Dao;
import com.katsubo.task3.dao.DaoImpl;
import com.katsubo.task3.validator.Validation;
import com.katsubo.task3.validator.ValidationImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DeviceService implements Service<Device> {
    private final static Logger log = LogManager.getLogger(DeviceService.class);
    private final static String schemaName = DeviceService.class.getResource("/data.xsd").getFile();
    private static Service instance = new DeviceService();
    private Dao dao = DaoImpl.getInstance();

    public static Service getInstance() {
        return instance;
    }

    private boolean checkFile(String fileName, String schemaName) {
        log.log(Level.INFO, "start velidation");
        Validation validation = new ValidationImpl();
        return validation.isValid(fileName, schemaName);
    }

    @Override
    public void load(String fileName, String builderName) {
        Builder builder = BuilderFactory.getInstance(builderName);
        if (checkFile(fileName, schemaName)) {
            log.log(Level.INFO, "start read file");
            builder.buildDevices(fileName);
        } else {
            log.log(Level.ERROR, "File is invalid, stop reading");
        }


        dao.set(builder.getDevices());
        log.log(Level.INFO, "success reading file");
    }

    @Override
    public List<Device> getBeans() {
        log.log(Level.INFO, "return devices");
        return dao.get();
    }
}
