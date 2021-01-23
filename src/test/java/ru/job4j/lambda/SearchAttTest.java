package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static ru.job4j.lambda.SearchAtt.filterName;
import static ru.job4j.lambda.SearchAtt.filterSize;

public class SearchAttTest {

    @Test
    public void filterByName() {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        List<Attachment> exp = Arrays.asList(
                new Attachment("image 2", 34)
        );
        List<Attachment> rsl = filterName(attachments, "image 2");
        assertThat(rsl, is(exp));
    }

    @Test
    public void filterBySize() {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        List<Attachment> exp = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34)
        );
        List<Attachment> rsl = filterSize(attachments, 30);
        assertThat(rsl, is(exp));
    }
}