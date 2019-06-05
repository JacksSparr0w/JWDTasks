package com.katsubo.bean;

public class Car extends Toy{

    {
        setType(Type.CAR);
    }
    public Car(){

    }

    public Car(Color color, Material material, int minAge, int maxAge, int price){
        setColor(color);
        setMaterial(material);
        setMinAge(minAge);
        setMaxAge(maxAge);
        setPrice(price);
    }
}
