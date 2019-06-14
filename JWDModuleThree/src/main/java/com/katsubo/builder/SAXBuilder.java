package com.katsubo.builder;

import com.katsubo.bean.Device;
import com.katsubo.bean.Group;
import com.katsubo.bean.Port;
import com.katsubo.bean.Type;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class SAXBuilder extends Builder {
    private final static Logger log = LogManager.getLogger(SAXBuilder.class);

    @Override
    public void buildDevices(String fileName) {
        SAXParserFactory factory;
        factory = SAXParserFactory.newInstance();

        DefaultHandler handler = new DefaultHandler() {
            Device device;
            Type type;
            List<Port> ports;

            String lastElement;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
                switch (qName) {
                    case "device":
                        log.log(Level.INFO, "create new device");

                        device = new Device();
                        device.setId(Integer.valueOf(atts.getValue("id")));
                        device.setCritical(Boolean.valueOf(atts.getValue("critical")));
                        break;
                    case "type":
                        log.log(Level.INFO, "create new type of device");
                        type = new Type();
                        type.setPeripheral(Boolean.valueOf(atts.getValue("peripheral")));
                        type.setCooler(Boolean.valueOf(atts.getValue("cooler")));
                        break;
                    case "ports":
                        log.log(Level.INFO, "create new ports of device");
                        ports = new ArrayList<>();
                }
                lastElement = qName;
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String data = new String(ch, start, length);
                switch (lastElement) {
                    case "name":
                        device.setName(data);
                        break;
                    case "origin":
                        device.setOrigin(data);
                        break;
                    case "price":
                        device.setPrice(Integer.valueOf(data));
                        break;
                    case "deviceType":
                        type.setName(data);
                        break;
                    case "port":
                        ports.add(Port.of(data).get());
                        break;
                    case "energy":
                        type.setEnergyUse(Integer.valueOf(data));
                        break;
                    case "group":
                        type.setGroup(Group.of(data).get());
                }
                lastElement = "";
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                switch (qName) {
                    case "type":
                        device.setType(type);
                        break;
                    case "device":
                        devices.add(device);
                        break;
                    case "ports":
                        type.setPorts(ports);
                }
            }
        };

        try {
            log.log(Level.INFO, "start parse");
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(fileName, handler);
        } catch (Exception e) {
            log.log(Level.ERROR, e.getMessage());
            e.printStackTrace();
        }
    }
}