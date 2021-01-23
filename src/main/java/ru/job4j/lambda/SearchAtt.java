package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list, int size) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > size;
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list, String name) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains(name);
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (predicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
