package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> integerList;

    public EasyStream(List<Integer> list) {
        this.integerList = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> mapList = new ArrayList<>();
        for (Integer num : integerList) {
            mapList.add(fun.apply(num));
        }
        return new EasyStream(mapList);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> filterList = new ArrayList<>();
        for (Integer num : integerList) {
            if (fun.test(num)) {
                filterList.add(num);
            }
        }
        return new EasyStream(filterList);
    }

    public List<Integer> collect() {
        return this.integerList;
    }
}