package com.katsubo.ParserChain;

import com.katsubo.composite.LeafComponent;

public abstract class Parser implements ParserChain<LeafComponent> {
    private Parser next;

    @Override
    public ParserChain<LeafComponent> linkWidth(ParserChain<LeafComponent> next) {
        ((Parser) next).next = this;
        return next;
    }

    protected LeafComponent nextParse(String line) {
        if (next != null) {
            return next.parseLine(line);
        } else {
            return null;
        }
    }
}
