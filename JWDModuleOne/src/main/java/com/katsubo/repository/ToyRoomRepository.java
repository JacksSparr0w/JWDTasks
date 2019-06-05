package com.katsubo.repository;

import com.katsubo.bean.Toy;
import com.katsubo.repository.sort.SortBy;
import com.katsubo.repository.specification.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ToyRoomRepository implements Repository<Toy> {
    private static final Logger logger = LogManager.getLogger(ToyRoomRepository.class);
    private static final ToyRoomRepository instance = new ToyRoomRepository();

    private List<Toy> toys;

    private int minAge;
    private int maxAge;
    private int allMoney;
    private int money;

    private ToyRoomRepository(){
        toys = new ArrayList<>();
    }

    public static ToyRoomRepository getInstance() {
        return instance;
    }

    @Override
    public void add(Toy toy) {
        toys.add(toy);
        logger.log(Level.INFO, "New toy added");
    }


    @Override
    public void delete(Toy toy) {
        logger.log(Level.INFO, "Delete toy from toy room");
        toys.remove(toy);
    }

    @Override
    public void deleteAll() {
        logger.log(Level.INFO, "Clear toy room");
        toys.clear();
    }

    @Override
    public List<Toy> query(Specification<Toy> spec) {
        List<Toy> result = new ArrayList<>();
        for (Toy toy : toys) {
            if (spec.match(toy)) {
                result.add(toy);

            }

        }
        return result;
    }

    @Override
    public void sort(SortBy sortBy) {
        toys.sort(sortBy);
    }

    public List<Toy> getAll() {
        return toys;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {

            this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {

            this.maxAge = maxAge;
    }

    public int getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(int allMoney) {
        this.allMoney = allMoney;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(minAge).append(" ");
        result.append(maxAge).append("\n");

        for (Toy toy : toys){
            result.append("\n");
            result.append(toy);
        }

        return result.toString();
    }
}