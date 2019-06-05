package com.katsubo.test;

import com.katsubo.bean.Ball;
import com.katsubo.bean.BigCar;
import com.katsubo.bean.Color;
import com.katsubo.bean.Material;
import com.katsubo.repository.Repository;
import com.katsubo.repository.ToyRoomRepository;

public class Test {
    public static void main(String[] args){
        Repository rep = ToyRoomRepository.getInstance();
        rep.setMinAge(0);
        rep.setMaxAge(12);
        rep.add(new BigCar(Color.RED, Material.GLASS, 3, 6, 1000));
        rep.add(new Ball(Color.BLUE, Material.RUBBER, 3, 6, 500));
        rep.add(new BigCar(Color.RED, Material.GLASS, 3, 6, 250));
        System.out.println(rep);
    }
}
