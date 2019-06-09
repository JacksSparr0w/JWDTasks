package com.katsubo.dao;

import java.util.List;

public interface Dao<T> {
    void set();

    List<T> get();
}
