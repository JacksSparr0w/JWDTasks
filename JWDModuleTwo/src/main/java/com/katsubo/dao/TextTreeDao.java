package com.katsubo.dao;

import com.katsubo.composite.CompositeComponent;
import com.katsubo.composite.LeafComponent;

public class TextTreeDao implements Dao<LeafComponent> {
    private CompositeComponent root;

    public TextTreeDao(LeafComponent root) {
        this.root = (CompositeComponent) root;
    }

    @Override
    public void addComponent(LeafComponent component) {
        root.addComponent(component);
    }

    @Override
    public LeafComponent getRoot() {
        return root;
    }

    @Override
    public String getAllTree() {
        return root.getContent();
    }
}
