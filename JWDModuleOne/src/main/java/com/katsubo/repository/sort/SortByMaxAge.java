package com.katsubo.repository.sort;

import com.katsubo.bean.Toy;

public class SortByMaxAge implements SortBy {
    @Override
    public int compare(Toy t1, Toy t2) {
        return t1.getMaxAge() - t2.getMaxAge();
    }
}
