package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparatorSize = new Comparator<>() {
            @Override
            public int compare(Attachment first, Attachment second) {
                return Integer.compare(first.getSize(), second.getSize());
            }
        };
        attachments.sort(comparatorSize);
        System.out.println(attachments);
        Comparator<Attachment> comparatorName = new Comparator<>() {
            @Override
            public int compare(Attachment first, Attachment second) {
                return first.getName().compareTo(second.getName());
            }
        };
        attachments.sort(comparatorName);
        System.out.println(attachments);
    }
}
