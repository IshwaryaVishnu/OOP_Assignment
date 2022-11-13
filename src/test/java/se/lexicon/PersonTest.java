package se.lexicon;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    @Test
public void getSummaryTest(){
        Person person1 =new Person(1,"ishu","sankar","ishu27.v@gmail.com");
        String expected ="Person{id=1, firstName='ishu', lastName='sankar', email='ishu27.v@gmail.com'}";
        String actual = person1.toString();
        Assert.assertEquals(expected,actual);
    }
}
