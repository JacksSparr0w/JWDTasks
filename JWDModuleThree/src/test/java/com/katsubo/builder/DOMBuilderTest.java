package com.katsubo.builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DOMBuilderTest {
    Builder builder;

    @Before
    public void prepare() {
        builder = new DOMBuilder();
        try {
            builder.buildDevices("src/test/resources/data.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successTest() {
        String actual = builder.getDevices().toString();

        String expected = "[Device {1 genius q250 ru 879 Type {keyboard false 780 true MEMORY [JACK, USB, HDMI]} true}, " +
                "Device {2 xiaomi mi7 us 755 Type {microphone false 200 true IO_DEVICE [JACK, PCI]} false}, " +
                "Device {3 samsing pl100 by 609 Type {keyboard false 430 true IO_DEVICE [PCI, USB]} false}, " +
                "Device {4 samsing pl100 de 650 Type {mouse true 700 true MULTIMEDIA [USB, JACK]} false}, " +
                "Device {5 a4tech a100 us 165 Type {clock false 370 true POWER_SUPPLY [COM, HDMI, USB]} false}, " +
                "Device {6 a4tech a100 us 188 Type {keyboard false 30 false POWER_SUPPLY [JACK]} true}, " +
                "Device {7 bloody q7 us 928 Type {microphone true 710 false IO_DEVICE [USB]} false}, " +
                "Device {8 a4tech a100 by 219 Type {mouse true 430 false MULTIMEDIA [COM]} false}, " +
                "Device {9 amazfit bip fr 548 Type {keyboard false 790 true POWER_SUPPLY [HDMI, COM]} false}, " +
                "Device {10 samsing pl100 de 523 Type {microphone false 550 true MEMORY [ETHERNET, COM, JACK]} true}, " +
                "Device {11 genius q250 us 227 Type {mouse false 280 false MEMORY [JACK, ETHERNET, PCI, COM]} false}, " +
                "Device {12 a4tech a100 ru 690 Type {printer true 680 true MEMORY [PCI, USB]} false}, " +
                "Device {13 xiaomi mi7 fr 484 Type {mouse false 370 true MULTIMEDIA [COM, ETHERNET, PCI, USB]} false}, " +
                "Device {14 samsing pl100 ru 293 Type {mouse false 470 false POWER_SUPPLY [USB, JACK]} true}, " +
                "Device {15 bloody q7 ru 558 Type {mouse true 350 true IO_DEVICE [HDMI, JACK]} false}, " +
                "Device {16 xiaomi mi7 ru 796 Type {keyboard false 350 true POWER_SUPPLY [PCI, COM]} true}, " +
                "Device {17 bloody q7 us 46 Type {mouse true 20 false MULTIMEDIA [USB]} false}]";


        Assert.assertEquals(expected, actual);
    }

}