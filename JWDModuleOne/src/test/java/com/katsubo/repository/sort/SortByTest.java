package com.katsubo.repository.sort;

import com.katsubo.bean.Toy;
import com.katsubo.exception.ServiceException;
import com.katsubo.repository.Repository;
import com.katsubo.repository.RepositoryFactory;
import com.katsubo.repository.RepositoryType;
import com.katsubo.service.Service;
import com.katsubo.service.ToyRoomService;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class SortByTest {
    private static Service service;
    private static Repository repository;

    @Before
    public void prepare() throws ServiceException {
        repository = RepositoryFactory.getRepository(RepositoryType.TOY_ROOM);
        service = ToyRoomService.getInstance();
        service.setAllMoney(10000);
        service.load();
    }

    @Test
    public void SortByColor() {
        service.sort(new SortByColor());

        List<Toy> toys = service.getAll();
        List<String> actual = new ArrayList<>();
        for (Toy toy : toys)
            actual.add(toy.toString());

        List<String> expected = new ArrayList<>();
        expected.add("BALL BLUE RUBBER 3 9 100");
        expected.add("DOLL BLUE RUBBER 0 6 1000");
        expected.add("CAR BLUE RUBBER 1 4 321");
        expected.add("BIG_CAR RED GLASS 3 6 250");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void SortByPrice() {
        service.sort(new SortByPrice());

        List<Toy> toys = service.getAll();
        List<String> actual = new ArrayList<>();
        for (Toy toy : toys)
            actual.add(toy.toString());

        List<String> expected = new ArrayList<>();
        expected.add("BALL BLUE RUBBER 3 9 100");
        expected.add("BIG_CAR RED GLASS 3 6 250");
        expected.add("CAR BLUE RUBBER 1 4 321");
        expected.add("DOLL BLUE RUBBER 0 6 1000");
        Assert.assertEquals(expected, actual);
    }

    @After
    public void clean(){
        repository.deleteAll();
    }
}