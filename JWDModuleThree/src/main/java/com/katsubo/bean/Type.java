package com.katsubo.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return peripheral == type.peripheral &&
                energyUse == type.energyUse &&
                cooler == type.cooler &&
                Objects.equals(name, type.name) &&
                group == type.group &&
                Objects.equals(ports, type.ports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, peripheral, energyUse, cooler, group, ports);
    }

    @Override
    public String toString() {
        return "Type {" +
                name +
                ' ' + peripheral +
                " " + energyUse +
                " " + cooler +
                " " + group +
                " " + ports +
                '}';
    }
}
