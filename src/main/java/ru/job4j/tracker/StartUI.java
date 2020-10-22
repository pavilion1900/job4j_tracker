package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item first = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = first.getCreated().format(formatter);
        System.out.println("Текущие дата и время: " + currentDateTimeFormat);
        System.out.println(first);
    }
}
