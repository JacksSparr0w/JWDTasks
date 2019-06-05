package com.katsubo.service;

import com.katsubo.exception.ServiceException;
import com.katsubo.repository.sort.SortBy;
import com.katsubo.repository.specification.Specification;

import java.util.List;

public interface Service<T> {
    void save();

    void load();

    void setMinAge(int minAge) throws ServiceException;

    void setMaxAge(int maxAge) throws ServiceException;

    void setAllMoney(int money) throws ServiceException;

    List<T> query(Specification<T> spec); //find

    void sort(SortBy sort);

    List<T> getAll();



}
