package com.katsubo.entity;

import com.katsubo.composite.CompositeComponent;
import com.katsubo.composite.LeafComponent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Paragraph implements CompositeComponent {
    private static final Logger LOGGER = LogManager.getLogger(Paragraph.class);

    private List<LeafComponent> sentences;

    public Paragraph() {
        sentences = new ArrayList<LeafComponent>();
    }

    public void addComponent(LeafComponent component) {
        sentences.add(component);
    }

    public List<LeafComponent> getComponents() {
        return sentences;
    }

    public int getCountOfLeafs() {
        return sentences.size();
    }

    public String getContent() {
        LOGGER.log(Level.INFO, "return paragraph");
        return sentences.stream()
                .map(LeafComponent::getContent)
                .collect(Collectors.joining());

    }
}
