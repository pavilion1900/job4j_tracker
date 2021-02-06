package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static ru.job4j.stream.StreamFlatMap.matrixToList;

public class StreamFlatMapTest {

    @Test
    public void changeMatrix() {
        Integer[][] array = {{20, 72, 31}, {8, 17, 56}, {55, 98, 1}};
        List<Integer> exp = List.of(20, 72, 31, 8, 17, 56, 55, 98, 1);
        List<Integer> rsl = matrixToList(array);
        assertThat(rsl, is(exp));
    }
}