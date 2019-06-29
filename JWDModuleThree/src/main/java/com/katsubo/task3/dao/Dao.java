package com.katsubo.task3.dao;

import java.util.List;

public interface Dao<T> {

    void set(List<T> t);

    List<T> get();
}
