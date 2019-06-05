package com.katsubo.repository.specification;

import com.katsubo.bean.Toy;
import com.katsubo.bean.Type;

public class SpecificationByType implements Specification<Toy> {

    private Type searchType;

    public SpecificationByType(Type searchType){
        this.searchType = searchType;
    }
    @Override
    public boolean match(Toy toy) {
        return searchType == toy.getType();
    }
}
