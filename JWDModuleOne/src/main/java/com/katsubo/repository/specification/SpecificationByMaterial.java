package com.katsubo.repository.specification;

import com.katsubo.bean.Toy;
import com.katsubo.bean.Material;

public class SpecificationByMaterial implements Specification<Toy> {
    private Material searchMaterial;

    public SpecificationByMaterial(Material searchMaterial){
        this.searchMaterial = searchMaterial;
    }

    @Override
    public boolean match(Toy toy) {
        return searchMaterial == toy.getMaterial();
    }
}
