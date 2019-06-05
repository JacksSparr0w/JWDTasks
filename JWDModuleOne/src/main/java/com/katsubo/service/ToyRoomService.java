package com.katsubo.service;

import com.katsubo.bean.Toy;
import com.katsubo.exception.ParserException;
import com.katsubo.exception.ReaderException;
import com.katsubo.exception.SaverException;
import com.katsubo.exception.ServiceException;
import com.katsubo.parser.Parser;
import com.katsubo.parser.ParserFactory;
import com.katsubo.parser.ParserType;
import com.katsubo.reader.Reader;
import com.katsubo.reader.ReaderFactory;
import com.katsubo.reader.ReaderType;
import com.katsubo.repository.Repository;
import com.katsubo.repository.RepositoryFactory;
import com.katsubo.repository.RepositoryType;
import com.katsubo.repository.sort.SortBy;
import com.katsubo.repository.specification.Specification;
import com.katsubo.saver.Saver;
import com.katsubo.saver.SaverFactory;
import com.katsubo.saver.SaverType;
import com.katsubo.validation.ValidationFactory;
import com.katsubo.validation.ValidationType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ToyRoomService implements Service {

    private static final Logger logger = LogManager.getLogger(ToyRoomService.class);
    private static ToyRoomService instance = new ToyRoomService();
    private static String fileName = "src/main/resources/data_files/ValidData.txt";

    private Repository repository;
    //todo make singleton

    private ToyRoomService() {
        repository = RepositoryFactory.getRepository(RepositoryType.TOY_ROOM);
    }

    public static ToyRoomService getInstance() {
        return instance;
    }


    @Override
    public void save() {
        try {
            Saver saver = SaverFactory.getSaver(SaverType.SAVER_TXT);
            saver.save(repository.getAll(), fileName);
            logger.log(Level.INFO, "Save success");
        } catch (SaverException e) {
            logger.log(Level.ERROR, e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void load() {
        try {
            Reader reader = ReaderFactory.getReader(ReaderType.FILE_READER);
            List<String> lines = reader.read(fileName);
            Parser parser = ParserFactory.getParser(ParserType.PARSER_TXT);
            parser.setValidation(ValidationFactory.getValidation(ValidationType.TOY));
            List<Toy> result = parser.parse(lines);
            for (Toy toy : result)
                add(toy);
            logger.log(Level.INFO, "Write new toys");
        } catch (ReaderException | ParserException e) {
            logger.log(Level.ERROR, e.getMessage());
            e.printStackTrace();
        }

    }

    private boolean ageIsCorrect(Toy toy) {
        int min = repository.getMinAge();
        int max = repository.getMaxAge();
        if (min == max && min == 0) {
            logger.log(Level.INFO, "Ages is not initialized, so add all");
            return true;
        }
        if (min > toy.getMinAge()) {
            logger.log(Level.INFO, "Age range of toy is incorrect for this room");
            return false;
        }
        return max >= toy.getMaxAge();
    }

    private void add(Toy toy) {
        if (ageIsCorrect(toy)) {
            if (repository.getMoney() >= toy.getPrice()) {
                repository.setMoney(repository.getMoney() - toy.getPrice());
                repository.add(toy);
            } else {
                logger.log(Level.ERROR, "Age is incorrect");
            }
        } else {
            logger.log(Level.ERROR, "Not enough money for this toy!");
        }
    }

    @Override
    public void setMinAge(int minAge) throws ServiceException {
        if (minAge >= 0)
            repository.setMinAge(minAge);
        else {
            logger.log(Level.ERROR, "MinAge is not positive");
            throw new ServiceException("MinAge is not positive");
        }

    }

    @Override
    public void setMaxAge(int maxAge) throws ServiceException {
        if (maxAge >= repository.getMinAge())
            repository.setMaxAge(maxAge);
        else {
            logger.log(Level.ERROR, "MaxAge less than minAge");
            throw new ServiceException("MaxAge less than minAge");
        }
    }

    @Override
    public void setAllMoney(int money) throws ServiceException {
        if (money > 0)
            repository.setAllMoney(money);
        else {
            logger.log(Level.ERROR, "Money is not positive");
            throw new ServiceException("Money is not positive");
        }
    }

    @Override
    public List query(Specification spec) {
        return repository.query(spec);
    }

    @Override
    public void sort(SortBy sort) {
        repository.sort(sort);
    }

    @Override
    public List<Toy> getAll() {
        return repository.getAll();
    }


}
