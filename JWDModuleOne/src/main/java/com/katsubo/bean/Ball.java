package com.katsubo.bean;

public class Ball extends Toy{
    {
        setType(Type.BALL);
    }

    public Ball(){
        super();

    }

    public Ball(Color color, Material material, int minAge, int maxAge, int price) {
        setColor(color);
        setMaterial(material);
        setMinAge(minAge);
        setMaxAge(maxAge);
        setPrice(price);
    }
}
