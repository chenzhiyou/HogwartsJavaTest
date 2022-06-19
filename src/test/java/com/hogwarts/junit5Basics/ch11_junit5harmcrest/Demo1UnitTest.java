package com.hogwarts.junit5Basics.ch11_junit5harmcrest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Demo1UnitTest {

    @Test
    void UsingIsForMatch(){
        String testString = "hamcrest is String";
        assertThat(testString, is("hamcrest is String"));
    }

    @Test
    void UsingEqualToForMatch(){
        String actualString = "equalTo match";
        List<String> actualList = Arrays.asList("equalTo", "match");
        Object original = 100;

        assertThat(actualString, is(equalTo("equalTo match")));
    }

    @Test
    void UsingNotForMatch(){
        String testString = "hamcrest not match ";
        assertThat(testString, not("equalTo match"));
        assertThat(testString, is(not(equalTo("hamcrest other match"))));
        assertThat(testString, is(not(instanceOf(Integer.class))));
    }

    @Test
    void UsingHasItemForMatch(){
        List<String> list = Arrays.asList("java", "hamcrest", "junit5");

        assertThat(list, hasItem("java"));
        assertThat(list, hasItem("junit5"));
        assertThat(list, hasItem(isA(String.class)));

        assertThat(list, hasItems("java", "junit5"));
        assertThat(list, hasItems(isA(String.class), endsWith("5")));
    }
}
