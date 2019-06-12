package com.katsubo.test;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generate {
    public static void main(String[] args) {

        int id = 1;
        Random random = new Random();

        String[] name = new String[]{"a4tech a100", "genius q250", "genuis f1", "bloody q7", "samsing pl100",
                "amazfit bip", "xiaomi mi7"};
        String[] origin = new String[]{"us", "ru", "by", "fr", "de"};
        String[] deviceTypes = new String[]{"mouse", "keyboard", "microphone", "wi-fi adapter", "clock", "printer",};

        String[] ports = new String[]{"com", "usb", "jack", "ethernet", "hdmi", "pci"};

        String[] group = new String[]{"multimedia", "io_device", "power_supply", "memory"};
        //todo


        try
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("devices");
            document.appendChild(rootElement);

            for (int i = 0; i < 17; i++) {

                Element device = document.createElement("device");
                rootElement.appendChild(device);

                Attr attr = document.createAttribute("id");
                attr.setValue(String.valueOf(id));
                device.setAttributeNode(attr);

                attr = document.createAttribute("critical");
                attr.setValue(String.valueOf(random.nextBoolean()));
                device.setAttributeNode(attr);

                Element element = document.createElement("name");
                element.appendChild(document.createTextNode(name[random.nextInt(name.length)]));
                device.appendChild(element);

                element = document.createElement("origin");
                element.appendChild(document.createTextNode(origin[random.nextInt(origin.length)]));
                device.appendChild(element);

                element = document.createElement("price");
                element.appendChild(document.createTextNode(String.valueOf(random.nextInt(1000))));
                device.appendChild(element);
                //============
                Element type = document.createElement("type");
                device.appendChild(type);

                attr = document.createAttribute("cooler");
                attr.setValue(String.valueOf(random.nextBoolean()));
                type.setAttributeNode(attr);

                attr = document.createAttribute("peripheral");
                attr.setValue(String.valueOf(random.nextBoolean()));
                type.setAttributeNode(attr);

                element = document.createElement("deviceType");
                element.appendChild(document.createTextNode(deviceTypes[random.nextInt(deviceTypes.length)]));
                type.appendChild(element);

                Element port = document.createElement("ports");
                type.appendChild(port);

                List<String> portsList = new ArrayList<>(Arrays.asList(ports));
                for (int j = 0; j < random.nextInt(4) + 1; j++){
                    element = document.createElement("port");
                    String port1 = portsList.remove(random.nextInt(portsList.size()));
                    element.appendChild(document.createTextNode(port1));
                    port.appendChild(element);
                }

                element = document.createElement("energy");
                element.appendChild(document.createTextNode(String.valueOf(random.nextInt(80)*10)));
                type.appendChild(element);

                element = document.createElement("group");
                element.appendChild(document.createTextNode(group[random.nextInt(group.length)]));
                type.appendChild(element);

                id++;

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult("data.xml");

            transformer.transform(domSource, streamResult);
            System.out.println("Файл сохранен!");
        }
        catch (ParserConfigurationException pce)
        {
            System.out.println(pce.getLocalizedMessage());
            pce.printStackTrace();
        }
        catch (TransformerException te)
        {
            System.out.println(te.getLocalizedMessage());
            te.printStackTrace();
        }
    }
}
