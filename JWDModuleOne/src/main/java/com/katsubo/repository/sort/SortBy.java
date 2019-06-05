package com.katsubo.repository.sort;

import com.katsubo.bean.Toy;

import java.util.Comparator;

@FunctionalInterface
public interface SortBy extends Comparator<Toy> {

    @Override
    public int compare(Toy t1, Toy t2);

}
