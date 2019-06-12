package com.katsubo.service;

import com.katsubo.bean.Device;
import com.katsubo.builder.Builder;
import com.katsubo.builder.BuilderFactory;
import com.katsubo.dao.Dao;
import com.katsubo.dao.DaoImpl;
import com.katsubo.validator.Validation;
import com.katsubo.validator.ValidationImpl;

import java.util.List;

public class ServiceImpl implements Service<Device> {
    Dao dao = DaoImpl.getInstance();

    @Override
    public boolean checkFile(String fileName, String schemaName) {
        Validation validation = new ValidationImpl();
        return validation.isValid(fileName, schemaName);
    }

    @Override
    public void load(String fileName, String builderName) {
        Builder builder = BuilderFactory.getInstance(builderName);
        try {
            builder.buildDevices("data");
        } catch (Exception e) {
            e.printStackTrace();
        }

        dao.set(builder.getDevices());
    }

    @Override
    public List<Device> get() {
        return dao.get();
    }
}
