package com.katsubo.entity;

import com.katsubo.composite.CompositeComponent;
import com.katsubo.composite.LeafComponent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence implements CompositeComponent {
    private static final Logger LOGGER = LogManager.getLogger(Sentence.class);
    private List<LeafComponent> words;

    public Sentence() {
        words = new ArrayList<LeafComponent>();
    }

    public void addComponent(LeafComponent component) {
        words.add(component);
    }

    public List<LeafComponent> getComponents() {
        return words;
    }

    public int getCountOfLeafs() {
        return words.size();
    }

    public String getContent() {
        LOGGER.log(Level.INFO, "return sentence");
        return words.stream()
                .map(LeafComponent::getContent)
                .map(n -> n.concat(" "))
                .map(n -> n.replace("& ", "\n"))
                .collect(Collectors.joining());


    }

}
