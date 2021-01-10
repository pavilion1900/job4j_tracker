package ru.job4j.comparator;

import java.util.*;

public class ThenComparingMethod {
    public static class User implements Comparable<User> {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public int compareTo(User another) {
            int rsl = this.getName().compareTo(another.getName());
            if (rsl == 0) {
                rsl = Integer.compare(another.getAge(), this.getAge());
            }
            return rsl;
        }
    }

    public static Comparator<User> thenComparing() {
        return ascByName().thenComparing(descByAge());
    }

    public static Comparator<User> ascByName() {
        return Comparator.naturalOrder();
    }

    public static Comparator<User> descByAge() {
        return Comparator.reverseOrder();
    }
}
