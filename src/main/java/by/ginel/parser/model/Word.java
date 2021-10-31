package by.ginel.parser.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Word implements Component<String>{

    private String word;
    Logger LOGGER = LoggerFactory.getLogger(Word.class);

    @Override
    public void add(String word) {
        LOGGER.info("MODEL: string saved in word");
        this.word = word;
    }

    @Override
    public void delete(String word) {
        LOGGER.info("MODEL: word deleted");
        this.word = "";
    }

    @Override
    public String getElement(Integer index) {
        return word;
    }

    @Override
    public String toString() {
        return word+" ";
    }

}
