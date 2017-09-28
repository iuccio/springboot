package hello.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class GreetingTest {

    @Test
    public void shouldTest(){
        assertThat("true", is("true"));
    }

    @Test
    public void shouldTest1(){
        assertThat("true", is("true"));
    }

}