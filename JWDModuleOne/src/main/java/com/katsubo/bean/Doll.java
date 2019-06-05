package com.katsubo.bean;

public class Doll extends Toy {
    {
        setType(Type.DOLL);
    }
    public Doll(){

    }

    public Doll(Color color, Material material, int minAge, int maxAge, int price){
        setColor(color);
        setMaterial(material);
        setMinAge(minAge);
        setMaxAge(maxAge);
        setPrice(price);
    }
}
