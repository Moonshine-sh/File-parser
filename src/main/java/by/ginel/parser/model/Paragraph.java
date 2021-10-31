package by.ginel.parser.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Paragraph implements Component<Sentence>{

    private List<Sentence> sentences = new ArrayList<>();

    Logger LOGGER = LoggerFactory.getLogger(by.ginel.parser.model.Sentence.class);

    @Override
    public void add(Sentence sentence) {
        LOGGER.info("MODEL: add word to word list");
        sentences.add(sentence);
    }

    @Override
    public void delete(Sentence sentence) {
        LOGGER.info("MODEL: delete word from word list");
        sentences.remove(sentence);
    }

    @Override
    public Sentence getElement(Integer index) {
        return sentences.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Sentence sentence : sentences) {
            stringBuilder.append(sentence);
        }
        return stringBuilder.toString()+"\n";
    }
}
