package com.katsubo.parser;

import com.katsubo.bean.BeanFactory;
import com.katsubo.bean.Toy;
import com.katsubo.bean.Color;
import com.katsubo.bean.Material;
import com.katsubo.bean.Type;
import com.katsubo.exception.EnumException;
import com.katsubo.exception.ParserException;
import com.katsubo.validation.Validation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TextParser implements Parser{
    private static final Logger logger = LogManager.getLogger(TextParser.class);
    private Validation validation;


    public void setValidation(Validation validation){
        this.validation = validation;
    }

    @Override
    public List<Toy> parse(List<String> data) throws ParserException {
        try {
            if (validation.valid(data)) {
                logger.log(Level.INFO, "File is valid");
                return beginParse(data);
            }
            else throw new ParserException("Invalid data in file!");
        }
        catch (ParserException e){
            throw e;
        }
    }

    private List<Toy> beginParse(List<String> lines) throws ParserException{
        List<Toy> toys= new ArrayList<>();
        logger.log(Level.INFO, "Begin to parse");
        //todo parse
        for (String line : lines){
            logger.log(Level.INFO, "start to parse new line");
            Toy toy;
            List<String> elements = new ArrayList<>(Arrays.asList(line.split(" ")));
            logger.log(Level.INFO, elements);
            try {
                Type type = Type.getType(elements.remove(0));
                Color color = Color.getColor(elements.remove(0));
                Material material = Material.getMaterial(elements.remove(0));
                int minAge = Integer.valueOf(elements.remove(0));
                int maxAge = Integer.valueOf(elements.remove(0));
                int price = Integer.valueOf(elements.remove(0));
                toy = BeanFactory.getToy(type, color, material, minAge, maxAge, price);

            } catch (EnumException e){
                throw new ParserException(e.getMessage());
            }


            toys.add(toy);
        }
        logger.log(Level.INFO, "Parse done!");


        return toys;

    }
}
