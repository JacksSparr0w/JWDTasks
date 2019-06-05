package com.katsubo.repository.sort;

import com.katsubo.bean.Toy;

public class SortByColor implements SortBy {
    @Override
    public int compare(Toy t1, Toy t2) {
        return t1.getColor().toString().compareTo(t2.getColor().toString());
        //return t1.getColor().compareTo(t2.getColor());
    }
}
