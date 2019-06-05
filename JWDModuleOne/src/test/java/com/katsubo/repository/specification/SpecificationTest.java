package com.katsubo.repository.specification;

import com.katsubo.bean.Toy;
import com.katsubo.bean.Type;
import com.katsubo.exception.ServiceException;
import com.katsubo.repository.Repository;
import com.katsubo.repository.RepositoryFactory;
import com.katsubo.repository.RepositoryType;
import com.katsubo.service.Service;
import com.katsubo.service.ToyRoomService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class SpecificationTest {
    Service service;
    Repository repository;

    @Before
    public void prepare() throws ServiceException {
        repository = RepositoryFactory.getRepository(RepositoryType.TOY_ROOM);
        service = ToyRoomService.getInstance();
        service.setAllMoney(10000);
        service.load();
    }

    @Test
    public void findAllBalls(){
        List<Toy> toys = service.query(new SpecificationByType(Type.BALL));
        List<String> actual = new ArrayList<>();
        for (Toy toy : toys)
            actual.add(toy.toString());

        List<String> expected = new ArrayList<>();
        expected.add("BALL BLUE RUBBER 3 9 100");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllToyWithPrice321(){
        int searchPrice = 321;
        List<Toy> toys = service.query(new SpecificationByPrice(searchPrice));
        List<String> actual = new ArrayList<>();
        for (Toy toy : toys)
            actual.add(toy.toString());

        List<String> expected = new ArrayList<>();
        expected.add("CAR BLUE RUBBER 1 4 321");

        Assert.assertEquals(expected, actual);
    }

    @After
    public void clean(){
        repository.deleteAll();
    }

}