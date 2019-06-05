package com.katsubo.repository.specification;

import com.katsubo.bean.Toy;

public class SpecificationByPrice implements Specification<Toy> {
    private int searchPrice;

    public SpecificationByPrice(int searchPrice){
        this.searchPrice = searchPrice;
    }

    @Override
    public boolean match(Toy toy) {
        return searchPrice == toy.getPrice();
    }
}
