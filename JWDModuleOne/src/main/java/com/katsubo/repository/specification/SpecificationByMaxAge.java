package com.katsubo.repository.specification;

import com.katsubo.bean.Toy;

public class SpecificationByMaxAge implements Specification<Toy> {
    private int searchMaxAge;

    public SpecificationByMaxAge(int searchMaxAge){
        this.searchMaxAge = searchMaxAge;
    }

    @Override
    public boolean match(Toy toy) {
        return searchMaxAge == toy.getMaxAge();
    }
}

