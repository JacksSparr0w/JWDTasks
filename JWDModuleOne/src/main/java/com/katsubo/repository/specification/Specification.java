package com.katsubo.repository.specification;

@FunctionalInterface
public interface Specification<T> {

    boolean match(T t);
}
