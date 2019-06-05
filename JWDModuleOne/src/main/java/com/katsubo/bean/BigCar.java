package com.katsubo.bean;

public class BigCar extends Toy {

    {
        setType(Type.BIG_CAR);
    }
    public BigCar(){

    }

    public BigCar(Color color, Material material, int minAge, int maxAge, int price){
        setColor(color);
        setMaterial(material);
        setMinAge(minAge);
        setMaxAge(maxAge);
        setPrice(price);
    }
}
