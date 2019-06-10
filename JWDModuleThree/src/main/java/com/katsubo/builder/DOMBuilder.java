package com.katsubo.builder;

import com.katsubo.bean.Device;
import com.katsubo.bean.Group;
import com.katsubo.bean.Port;
import com.katsubo.bean.Type;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DOMBuilder extends Builder {
    private Document document;

    public void buildDevices(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
            //todo
        }
        document.getDocumentElement().normalize();

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
        device.setCritical(Boolean.valueOf(element.getAttribute("critical")));

        device.setName(element.getElementsByTagName("name").item(0).getTextContent());
        device.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
        device.setPrice(Integer.valueOf(element.getElementsByTagName("price").item(0).getTextContent()));

        Type type = buildType(element.getElementsByTagName("type"));
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

                List<Port> ports = buildPorts(element.getElementsByTagName("ports"));
                type.setPorts(ports);


            }
        }
        return type;
    }

    private List<Port> buildPorts(NodeList nodes) {
        List<Port> ports = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Port port = Port.of(element.getElementsByTagName("port").item(i).getTextContent()).get();
                ports.add(port);
            }
        }
        return ports;
    }
}