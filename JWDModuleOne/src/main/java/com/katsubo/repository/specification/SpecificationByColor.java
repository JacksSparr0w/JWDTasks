package com.katsubo.repository.specification;

import com.katsubo.bean.Toy;
import com.katsubo.bean.Color;

public class SpecificationByColor implements Specification<Toy> {
    private Color searchColor;

    public SpecificationByColor(Color searchColor){
        this.searchColor = searchColor;
    }

    @Override
    public boolean match(Toy toy) {
        return searchColor == toy.getColor();
    }
}
