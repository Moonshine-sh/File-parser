package comparator;

import by.ginel.parser.comparator.SentenceComparator;
import by.ginel.parser.model.Sentence;
import by.ginel.parser.model.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SentenceComparatorTest {

    @Test
    public void compareTest(){
        Sentence sentence = new Sentence();
        Sentence sentence1 = new Sentence();
        Word word = new Word();
        Word word1 = new Word();
        word.add("sample");
        word1.add("exmpl");
        SentenceComparator sc = new SentenceComparator();
        sentence.add(word);
        sentence.add(word1);
        sentence1.add(word1);
        Assertions.assertEquals(1,sc.compare(sentence,sentence1));
    }
}
