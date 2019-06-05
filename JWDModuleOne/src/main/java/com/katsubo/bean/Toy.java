package com.katsubo.bean;

import java.util.Objects;

public abstract class Toy {
    private Type type;
    private Color color;
    private Material material;
    private int minAge;
    private int maxAge;
    private int price;

    public Toy(Type type, Color color, Material material, int minAge, int maxAge, int price) {
        this.type = type;
        this.color = color;
        this.material = material;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        if (minAge >= 0)
            this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        if (maxAge >= minAge)
            this.maxAge = maxAge;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return  minAge == toy.minAge &&
                maxAge == toy.maxAge &&
                type == toy.type &&
                color == toy.color &&
                material == toy.material &&
                price == toy.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, material, minAge, maxAge, price);
    }

    @Override
    public String toString() {
        return type + " " + color + " "
                + material + " " + minAge + " " + maxAge + " " + price;

    }
}
