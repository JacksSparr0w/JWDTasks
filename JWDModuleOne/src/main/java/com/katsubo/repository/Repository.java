package com.katsubo.repository;

import com.katsubo.repository.sort.SortBy;
import com.katsubo.repository.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    int getMinAge();

    void setMinAge(int minAge);

    int getMaxAge();

    void setMaxAge(int maxAge);

    void add(T t);

    void delete(T t);

    void deleteAll();

    List<T> query(Specification<T> spec);

    void sort(SortBy sort);

    List<T> getAll();

    public int getAllMoney();

    public void setAllMoney(int allMoney);

    public int getMoney();

    public void setMoney(int money);

}
