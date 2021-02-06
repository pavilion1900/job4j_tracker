package ru.job4j.tracker.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = human -> human.getName().contains(key);
        Predicate<Person> checkSurname = human -> human.getSurname().contains(key);
        Predicate<Person> checkPhone = human -> human.getPhone().contains(key);
        Predicate<Person> checkAddress = human -> human.getAddress().contains(key);
        Predicate<Person> combine = checkName.or(checkSurname).or(checkPhone).or(checkAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}