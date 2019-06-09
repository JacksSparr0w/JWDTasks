package com.katsubo.builder;

import com.katsubo.bean.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMBuilder extends Builder {
    private Document document;

    public void buildDevices() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        document = builder.parse(new File("src/main/resources/data.xml"));

        document.getDocumentElement().normalize();

        //Element root = document.getDocumentElement();

        NodeList nodes = document.getElementsByTagName("device");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Device device = buildDevice(element);
                devices.add(device);
            }
        }
    }

    private Device buildDevice(Element element) {
        Device device = new Device();
        device.setId(Integer.valueOf(element.getAttribute("id")));
        device.setCritical(Boolean.getBoolean(element.getAttribute("critical")));

        device.setName(element.getElementsByTagName("name").item(0).getTextContent());
        device.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
        device.setPrice(Integer.valueOf(element.getElementsByTagName("price").item(0).getTextContent()));

        Type type = buildType(document.getElementsByTagName("type"));
        device.setType(type);

        return device;
    }

    private Type buildType(NodeList nodes) {
        Type type = new Type();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                type.setPeripheral(Boolean.valueOf(element.getAttribute("peripheral")));
                type.setCooler(Boolean.valueOf(element.getAttribute("cooler")));

                type.setEnergyUse(Integer.valueOf(element.getElementsByTagName("energy").item(0).getTextContent()));
                type.setGroup(Group.of(element.getElementsByTagName("group").item(0).getTextContent()).get());
                type.setName(element.getElementsByTagName("deviceType").item(0).getTextContent());

                List<Port> ports = buildPorts(document.getElementsByTagName("ports"));
                type.setPorts(ports);


            }
        }
        return type;
    }

    private List<Port> buildPorts(NodeList nodes) {
        List<Port> ports = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node3 = nodes.item(i);
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node3;
                Port port = Port.of(element.getElementsByTagName("port").item(i).getTextContent()).get();
                ports.add(port);
            }
        }
        return ports;
    }
}