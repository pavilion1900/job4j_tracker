package ru.job4j.tracker.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LexSortTest {

    @Test
    public void compare() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."};
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."};
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}