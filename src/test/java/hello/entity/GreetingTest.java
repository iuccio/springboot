package hello.entity;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GreetingTest {

    @Test
    private void shouldTest(){
        assertThat("true", is("false"));
    }

}