package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    public static Map<String, Student> listToMap(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(surname -> surname.getSurname(),
                        stud -> stud,
                        (stud1, stud2) -> stud1));
    }
}
