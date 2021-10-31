package by.ginel.parser.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Listing implements Component<Paragraph>{

    private List<Paragraph> paragraphs = new ArrayList<>();
    private final Logger LOGGER = LoggerFactory.getLogger(Listing.class);

    @Override
    public void add(Paragraph paragraph) {
        LOGGER.info("MODEL: add sentence to sentences list");
        paragraphs.add(paragraph);
    }

    @Override
    public void delete(Paragraph paragraph) {
        LOGGER.info("MODEL: delete sentence from sentences list");
        paragraphs.remove(paragraph);
    }

    @Override
    public Paragraph getElement(Integer index) {
        return paragraphs.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Paragraph paragraph : paragraphs){
            stringBuilder.append(paragraph);
        }
        return stringBuilder.toString();
    }

}
