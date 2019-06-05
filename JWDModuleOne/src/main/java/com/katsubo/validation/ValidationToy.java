package com.katsubo.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ValidationToy implements Validation {
    private static final Logger logger = LogManager.getLogger(ValidationToy.class);

    private static final String regex = "^[A-Z]+\\_*[A-Z]*(\\s[A-Z]+){2}(\\s[0-9]+){3}$";

    @Override
    public boolean valid(List<String> lines) {
        for (String line : lines) {
            if (!line.matches(regex)) {
                logger.log(Level.ERROR, "Line " + lines.indexOf(line) + " invalid. Stop valodation");
                return false;
            }
            logger.log(Level.INFO, "Line " + lines.indexOf(line) + " valid");
        }
        return true;
    }
}
