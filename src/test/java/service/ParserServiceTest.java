package service;


import by.ginel.parser.model.Composite;
import by.ginel.parser.service.ParserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserServiceTest {

    @Test
    public void parseTest(){
        Composite composite = new Composite();
        ParserService compositeService = new ParserService(composite,"src/main/resources/text.txt");
        Composite composite2 = compositeService.parse();
        System.out.println(composite2.toString());
        compositeService.writeToFile(composite2);
        Assertions.assertEquals(1,composite2.getComponents().size());
    }

}
