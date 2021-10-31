package by.ginel.parser.comparator;

import by.ginel.parser.model.*;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceComparator implements Comparator<Sentence> {

    final Pattern pattern = Pattern.compile("\\w+");

    @Override
    public int compare(Sentence o1, Sentence o2) {
        String str1 = o1.toString();
        String str2 = o2.toString();
        int size1 = 0;
        int size2 = 0;

        Matcher match = pattern.matcher(str1);
        while (match.find()){
            match.group();
            size1++;
        }

        match = pattern.matcher(str2);
        while (match.find()){
            match.group();
            size2++;
        }
        if(size1 > size2){
            return 1;
        }
        if(size1 < size2){

            return -1;
        }
        return 0;
    }
}
