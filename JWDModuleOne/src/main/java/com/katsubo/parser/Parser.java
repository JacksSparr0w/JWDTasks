package com.katsubo.parser;

import com.katsubo.bean.Toy;
import com.katsubo.exception.ParserException;
import com.katsubo.validation.Validation;

import java.util.List;

public interface Parser{
    List<Toy> parse(List<String> data) throws ParserException;

    void setValidation(Validation validtion);

}
