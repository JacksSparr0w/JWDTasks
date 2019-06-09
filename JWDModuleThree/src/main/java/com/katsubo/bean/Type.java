package com.katsubo.bean;

import java.util.ArrayList;
import java.util.List;

public class Type {
    private String name;
    private boolean peripheral;
    private int energyUse;
    private boolean cooler;
    private Group group;
    private List<Port> ports;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPeripheral() {
        return peripheral;
    }

    public void setPeripheral(boolean peripheral) {
        this.peripheral = peripheral;
    }

    public int getEnergyUse() {
        return energyUse;
    }

    public void setEnergyUse(int energyUse) {
        if (energyUse >= 0)
            this.energyUse = energyUse;
    }

    public boolean isCooler() {
        return cooler;
    }

    public void setCooler(boolean cooler) {
        this.cooler = cooler;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
        //this.ports = new ArrayList<Port>();
        //System.arraycopy(ports, 0, this.ports, ports.size()-1, ports.size());
    }
}
