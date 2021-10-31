package by.ginel.parser.service;

import by.ginel.parser.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserService {

    private final Composite composite;
    private final String path;
    private final Pattern paragraphPattern = Pattern.compile("\\n?[\\d\\w,.:;?!\\-()'\\\"\\ ]*\\n?");
    private final Pattern sentencePattern = Pattern.compile("[\\d\\w,:;\\-()'\\\"\\ ]*[.!?]");
    private final Pattern wordPattern = Pattern.compile("[\\w']+|[-.,:;?!\\\"()]");
    private final Pattern charPattern = Pattern.compile(".");
    Logger LOGGER = LoggerFactory.getLogger(ParserService.class);

    public ParserService(Composite composite, String filePath) {
        this.composite = composite;
        this.path = filePath;
    }

    public Composite parse() {
        LOGGER.info("SERVICE: parsing text: {}", path);
        Listing listing = new Listing();
        try(FileReader fr = new FileReader(path)) {
            String text = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
            Matcher paragraphMatch = paragraphPattern.matcher(text);
            while (paragraphMatch.find()) {
                Paragraph paragraph = new Paragraph();
                Matcher sentenceMatch = sentencePattern.matcher(paragraphMatch.group());
                while (sentenceMatch.find()) {
                    Sentence sentence = new Sentence();
                    Matcher wordMatch = wordPattern.matcher(sentenceMatch.group());
                    while (wordMatch.find()) {
                        Word word = new Word();
                        word.add(wordMatch.group());
                        sentence.add(word);
                    }
                    paragraph.add(sentence);
                }
                listing.add(paragraph);
            }
        }catch (IOException ex){
            LOGGER.warn("SERVICE: Cannot open file to read: {}",path);
        }
        composite.add(listing);
        return composite;
    }

    public void writeToFile(Composite composite){
        LOGGER.info("SERVICE: open file to read: {}", path);
        try(FileWriter fr = new FileWriter("src/main/resources/RestoredText.txt")){
            fr.write(composite.toString());
        }
        catch (IOException ex){
            LOGGER.warn("SERVICE: Cannot open file to write: {}",path);
        }
    }
}
