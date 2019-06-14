package com.katsubo.service;

import com.katsubo.bean.Device;
import com.katsubo.builder.Builder;
import com.katsubo.builder.BuilderFactory;
import com.katsubo.dao.Dao;
import com.katsubo.dao.DaoImpl;
import com.katsubo.validator.Validation;
import com.katsubo.validator.ValidationImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ServiceImpl implements Service<Device> {
    private final static Logger log = LogManager.getLogger(ServiceImpl.class);
    Dao dao = DaoImpl.getInstance();

    @Override
    public boolean checkFile(String fileName, String schemaName) {
        log.log(Level.INFO, "start velidation");
        Validation validation = new ValidationImpl();
        return validation.isValid(fileName, schemaName);
    }

    @Override
    public void load(String fileName, String builderName) {
        Builder builder = BuilderFactory.getInstance(builderName);
        log.log(Level.INFO, "start read file");
        try {
            builder.buildDevices("data");
        } catch (Exception e) {
            log.log(Level.ERROR, e.getMessage());
            e.printStackTrace();
        }

        dao.set(builder.getDevices());
        log.log(Level.INFO, "success reading file");
    }

    @Override
    public List<Device> get() {
        log.log(Level.INFO, "return devices");
        return dao.get();
    }
}
