package com.katsubo.repository.sort;

import com.katsubo.bean.Toy;

public class SortByMinAge implements SortBy {
    @Override
    public int compare(Toy t1, Toy t2) {
        return t1.getMinAge() - t2.getMinAge();
    }
}
