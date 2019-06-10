package com.katsubo.builder;

import com.katsubo.bean.Device;
import com.katsubo.bean.Group;
import com.katsubo.bean.Port;
import com.katsubo.bean.Type;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXBuilder extends Builder {
    @Override
    public void buildDevices(String fileName) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            Device device = null;
            Type type = null;
            List<Port> ports = null;

            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "device":
                            device = new Device();
                            device.setId(Integer.valueOf(startElement.getAttributeByName(new QName("id")).getValue()));
                            device.setCritical(Boolean.valueOf(startElement.getAttributeByName(new QName("critical")).getValue()));
                            break;
                        case "type":
                            type = new Type();
                            type.setPeripheral(Boolean.valueOf(startElement.getAttributeByName(new QName("peripheral")).getValue()));
                            type.setPeripheral(Boolean.valueOf(startElement.getAttributeByName(new QName("cooler")).getValue()));
                            break;
                        case "ports":
                            ports = new ArrayList<>();
                            break;
                        case "name":
                            xmlEvent = xmlEventReader.nextEvent();
                            device.setName(xmlEvent.asCharacters().getData());
                            break;
                        case "origin":
                            xmlEvent = xmlEventReader.nextEvent();
                            device.setOrigin(xmlEvent.asCharacters().getData());
                            break;
                        case "price":
                            xmlEvent = xmlEventReader.nextEvent();
                            device.setPrice(Integer.valueOf(xmlEvent.asCharacters().getData()));
                            break;
                        case "deviceType":
                            xmlEvent = xmlEventReader.nextEvent();
                            type.setName(xmlEvent.asCharacters().getData());
                            break;
                        case "port":
                            xmlEvent = xmlEventReader.nextEvent();
                            ports.add(Port.of(xmlEvent.asCharacters().getData()).get());
                            break;
                        case "energy":
                            xmlEvent = xmlEventReader.nextEvent();
                            type.setEnergyUse(Integer.valueOf(xmlEvent.asCharacters().getData()));
                            break;
                        case "group":
                            xmlEvent = xmlEventReader.nextEvent();
                            type.setGroup(Group.of(xmlEvent.asCharacters().getData()).get());
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    switch (endElement.getName().getLocalPart()) {
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
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}