package ru.job4j.tracker.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobSorterTest {

    @Test
    public void whenSortByIncreaseName() {
        List<Job> list = Arrays.asList(
                new Job("reading", 4),
                new Job("writing", 1),
                new Job("speaking", 2),
                new Job("understanding", 3));
        Collections.sort(list, new JobIncreaseByName());
        List<Job> listExpected = Arrays.asList(
                new Job("reading", 4),
                new Job("speaking", 2),
                new Job("understanding", 3),
                new Job("writing", 1));
        assertThat(list, is(listExpected));
    }

    @Test
    public void whenSortByDecreaseName() {
        List<Job> list = Arrays.asList(
                new Job("reading", 4),
                new Job("writing", 1),
                new Job("speaking", 2),
                new Job("understanding", 3));
        Collections.sort(list, new JobDescByName());
        List<Job> listExpected = Arrays.asList(
                new Job("writing", 1),
                new Job("understanding", 3),
                new Job("speaking", 2),
                new Job("reading", 4));
        assertThat(list, is(listExpected));
    }

    @Test
    public void whenSortByIncreasePriority() {
        List<Job> list = Arrays.asList(
                new Job("reading", 4),
                new Job("writing", 1),
                new Job("speaking", 2),
                new Job("understanding", 3));
        Collections.sort(list, new JobIncreaseByPriority());
        List<Job> listExpected = Arrays.asList(
                new Job("writing", 1),
                new Job("speaking", 2),
                new Job("understanding", 3),
                new Job("reading", 4));
        assertThat(list, is(listExpected));
    }

    @Test
    public void whenSortByDecreasePriority() {
        List<Job> list = Arrays.asList(
                new Job("reading", 4),
                new Job("writing", 1),
                new Job("speaking", 2),
                new Job("understanding", 3));
        Collections.sort(list, new JobDescByPriority());
        List<Job> listExpected = Arrays.asList(
                new Job("reading", 4),
                new Job("understanding", 3),
                new Job("speaking", 2),
                new Job("writing", 1));
        assertThat(list, is(listExpected));
    }

    @Test
    public void whenComparatorByNameAndPriorityDecrease() {
        List<Job> list = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Impl task", 2),
                new Job("Fix bug", 3));
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        List<Job> listExpected = Arrays.asList(
                new Job("Impl task", 2),
                new Job("Impl task", 0),
                new Job("Fix bug", 3),
                new Job("Fix bug", 1));
        Collections.sort(list, cmpNamePriority);
        assertThat(list, is(listExpected));
    }

    @Test
    public void whenComparatorByNameAndPriorityDecrease2() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl1 = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 1));
        int rsl2 = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 3));
        assertThat(rsl1, is(0));
        assertThat(rsl2, lessThan(0));
    }
}