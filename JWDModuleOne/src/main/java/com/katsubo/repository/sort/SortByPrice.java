package com.katsubo.repository.sort;

import com.katsubo.bean.Toy;

public class SortByPrice implements SortBy {
    @Override
    public int compare(Toy t1, Toy t2) {
        return t1.getPrice() - t2.getPrice();
    }
}
