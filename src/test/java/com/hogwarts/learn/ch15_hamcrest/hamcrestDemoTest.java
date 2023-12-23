package com.hogwarts.learn.ch15_hamcrest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class hamcrestDemoTest {

    @Test
    void UsingIsForMatch(){
        String testString = "hamcrest core Is match";

        assertThat(testString, is("hamcrest core Is match"));
        assertThat(testString, is(equalTo("hamcrest core Is match")));
    }


    @Test
    void UsingEqualToForMatch(){
        String actualString = "equalTo match";
        List<String> actualList = Arrays.asList("equalTo", "match");
        Object original = 100;

        assertThat(actualString, is(equalTo("equalTo match")));
        assertThat(actualList, is(equalTo(Arrays.asList("equalTo", "match"))));
        assertThat(original, equalToObject(100));
    }

    @Test
    void UsingNotForMatch(){
        String testString = "hamcrest not match";

        assertThat(testString, not("hamcrest core Is match"));
        assertThat(testString, is(not(equalTo("hamcrest core Is match"))));
        assertThat(testString, is(not(instanceOf(Integer.class))));
    }

    @Test
    void UsingHasItemForMatch(){
        List<String> actualList = Arrays.asList("java", "hamcrest", "junit5");

        assertThat(actualList, hasItem("java"));
        assertThat(actualList, hasItem(isA(String.class)));

        assertThat(actualList, hasItems("java", "junit5"));
        assertThat(actualList, hasItems(isA(String.class), endsWith("est")));
    }

    @Test
    void UsingAllOfForMatch(){
        String testString = "Achilles is powerful";
        assertThat(testString, allOf(startsWith("Achi"), endsWith("ul"), containsString("Achilles")));
    }

    @Test
    void UsingBothForMatch(){
        String testString = "Achilles is powerful";
        assertThat(testString, both(startsWith("Achi")).and(containsString("Achilles")));
    }
}
