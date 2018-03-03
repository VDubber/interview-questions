package ident;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;


public class AnagramProcessorTest {

    @Test
    public void processTest() {
        String case1 = "A pot has a top but only on PTO. Tank kan't!. The dog has a god god. Gods and dogs. And the god's dog's food. DOGG";
        assertThat(AnagramProcessor.process(case1), containsInAnyOrder("pot", "top", "PTO", "Gods", "god's", "dogs", "dog's", "kan't", "Tank", "dog", "god"));

        String case2 = "Gods Dogs dog's";
        assertThat(AnagramProcessor.process(case2), containsInAnyOrder("Gods", "Dogs", "dog's"));
    }

    @Test
    public void processAndPrintTest() {
        String case1 = "A pot has a top but only on PTO. Tank kan't!. The dog has a god god. Gods and dogs. And the god's dog's food.";
        AnagramProcessor.processAndPrint(case1);

        AnagramProcessor.processAndPrint("Listen to the silent bird. They are fried with fired beef");
    }
}
