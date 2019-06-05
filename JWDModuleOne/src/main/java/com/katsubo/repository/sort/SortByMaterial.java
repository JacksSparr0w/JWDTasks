package com.katsubo.repository.sort;

import com.katsubo.bean.Toy;

public class SortByMaterial implements SortBy {
    @Override
    public int compare(Toy t1, Toy t2) {
        return t1.getMaterial().compareTo(t2.getMaterial());
    }
}
