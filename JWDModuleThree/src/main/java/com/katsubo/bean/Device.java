package com.katsubo.bean;

import java.util.Objects;

public class Device {
    private int id;
    private String name;
    private String origin;
    private int price;
    private Type type;
    private boolean critical;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return id == device.id &&
                price == device.price &&
                critical == device.critical &&
                Objects.equals(name, device.name) &&
                Objects.equals(origin, device.origin) &&
                Objects.equals(type, device.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, origin, price, type, critical);
    }

    @Override
    public String toString() {
        return "Device {" +
                id +
                " " + name +
                " " + origin +
                " " + price +
                " " + type +
                " " + critical +
                '}';
    }
}
