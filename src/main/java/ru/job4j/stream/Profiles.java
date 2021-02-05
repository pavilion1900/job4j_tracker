package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles
                .stream()
                .map(prof -> prof.getAddress())
                .sorted((first, second) -> first.getCity().compareTo(second.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }
}
