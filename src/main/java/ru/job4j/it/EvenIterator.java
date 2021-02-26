package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        while (point < data.length) {
            if (data[point] % 2 == 0) {
                rsl = true;
                break;
            }
            point++;
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int num = data[point];
        if (hasNext()) {
            point++;
            return num % 2 == 0 ? num : next();
        }
        return num;
    }
}
