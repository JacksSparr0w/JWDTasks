package com.katsubo.composite;

import java.util.List;

public interface CompositeComponent extends LeafComponent {
    void addComponent(LeafComponent component);

    List<LeafComponent> getComponents();

    int getCountOfLeafs();


}
