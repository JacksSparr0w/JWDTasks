package com.katsubo.repository.specification;

import com.katsubo.bean.Toy;

public class SpecificationByMinAge implements Specification<Toy> {
    private int searchMinAge;

    public SpecificationByMinAge(int searchMinAge){
        this.searchMinAge = searchMinAge;
    }

    @Override
    public boolean match(Toy toy) {
        return searchMinAge == toy.getMinAge();
    }
}
