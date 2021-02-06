package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static ru.job4j.stream.StudentMap.listToMap;

public class StudentMapTest {

    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(30, "Surname3"));
        students.add(new Student(40, "Surname4"));
        students.add(new Student(50, "Surname5"));
        students.add(new Student(60, "Surname6"));
        students.add(new Student(70, "Surname7"));
        students.add(new Student(80, "Surname8"));
        students.add(new Student(90, "Surname9"));
        students.add(new Student(90, "Surname9"));
        students.add(new Student(90, "Surname9"));
        students.add(new Student(90, "Surname9"));
    }

    @Test
    public void checkMap() {
        Map<String, Student> exp = new HashMap<>();
        exp.put("Surname1", new Student(10, "Surname1"));
        exp.put("Surname2", new Student(20, "Surname2"));
        exp.put("Surname3", new Student(30, "Surname3"));
        exp.put("Surname4", new Student(40, "Surname4"));
        exp.put("Surname5", new Student(50, "Surname5"));
        exp.put("Surname6", new Student(60, "Surname6"));
        exp.put("Surname7", new Student(70, "Surname7"));
        exp.put("Surname8", new Student(80, "Surname8"));
        exp.put("Surname9", new Student(90, "Surname9"));
        Map<String, Student> rsl = listToMap(students);
        assertThat(rsl, is(exp));
    }

    @Test
    public void checkMapWithDuplicateValue() {
        Map<String, Student> exp = new HashMap<>();
        exp.put("Surname1", new Student(10, "Surname1"));
        exp.put("Surname2", new Student(20, "Surname2"));
        exp.put("Surname3", new Student(30, "Surname3"));
        exp.put("Surname4", new Student(40, "Surname4"));
        exp.put("Surname5", new Student(50, "Surname5"));
        exp.put("Surname6", new Student(60, "Surname6"));
        exp.put("Surname7", new Student(70, "Surname7"));
        exp.put("Surname8", new Student(80, "Surname8"));
        exp.put("Surname9", new Student(90, "Surname9"));
        Map<String, Student> rsl = listToMap(students);
        assertThat(rsl, is(exp));
    }
}