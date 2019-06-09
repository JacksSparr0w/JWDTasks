package com.katsubo.builder;

import com.katsubo.bean.Device;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Builder {
    protected List<Device> devices = new ArrayList<Device>();

    List<Device> getDevices(){
        return devices;
    }

    public abstract void buildDevices() throws IOException, SAXException, ParserConfigurationException;

}
