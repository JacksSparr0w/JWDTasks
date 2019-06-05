package com.katsubo.dao;

public interface Dao<T> {

    void addComponent(T component);

    T getRoot();

    String getAllTree();
}
