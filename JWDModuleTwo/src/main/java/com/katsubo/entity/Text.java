package com.katsubo.entity;

import com.katsubo.composite.CompositeComponent;
import com.katsubo.composite.LeafComponent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Text implements CompositeComponent {
    private static final Logger LOGGER = LogManager.getLogger(Text.class);
    private List<LeafComponent> paragraphs;

    public Text() {
        paragraphs = new ArrayList<LeafComponent>();
    }

    public void addComponent(LeafComponent component) {
        paragraphs.add(component);
    }

    public List<LeafComponent> getComponents() {
        return paragraphs;
    }

    public int getCountOfLeafs() {
        return paragraphs.size();
    }

    public String getContent() {
        LOGGER.log(Level.INFO, "return text");
        String text = paragraphs.stream()
                .map(LeafComponent::getContent)
                .map(n -> "\t" + n)
                .collect(Collectors.joining());
        return "\t" + text.trim();
    }
}
