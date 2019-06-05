package com.katsubo.validation;

import java.util.List;
@FunctionalInterface
public interface Validation{

    boolean valid(List<String> lines);
}
