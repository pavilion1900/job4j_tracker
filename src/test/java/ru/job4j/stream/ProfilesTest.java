package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    private List<Profile> profilesList = new ArrayList<>();

    @Before
    public void setup() {
        Address first = new Address("Moscow", "Factory", 132, 10);
        Address second = new Address("Minsk", "9 may", 52, 5);
        Address third = new Address("Gomel", "Rechnay", 15, 42);
        Address fourth = new Address("Minsk", "9 may", 52, 5);
        Profile pro1 = new Profile(first);
        Profile pro2 = new Profile(second);
        Profile pro3 = new Profile(third);
        Profile pro4 = new Profile(fourth);
        profilesList.add(pro1);
        profilesList.add(pro2);
        profilesList.add(pro3);
        profilesList.add(pro4);
    }

    @Test
    public void collect() {
        List<Address> exp = List.of(
                new Address("Gomel", "Rechnay", 15, 42),
                new Address("Minsk", "9 may", 52, 5),
                new Address("Moscow", "Factory", 132, 10));
        List<Address> rsl = Profiles.collect(profilesList);
        assertThat(rsl, is(exp));
    }
}