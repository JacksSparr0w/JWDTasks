package com.katsubo.bean;

public class BeanFactory {
    public static Toy getToy(Type type, Color color, Material material, int minAge, int maxAge, int price) {
        Toy toy = null;
        switch (type) {
            case BIG_CAR:
                toy = new BigCar(color, material, minAge, maxAge, price);
                break;
            case BALL:
                toy = new Ball(color, material, minAge, maxAge, price);
                break;
            case CAR:
                toy = new Car(color, material, minAge, maxAge, price);
                break;
            case DOLL:
                toy = new Doll(color, material, minAge, maxAge, price);
        }
        return toy;
    }
}
