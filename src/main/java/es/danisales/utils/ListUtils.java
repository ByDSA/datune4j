package es.danisales.utils;

import java.util.*;

public class ListUtils {
    private ListUtils() {
    }

    public static<T> List<T> concatUnmodificable(List<T>... lists) {
        List<T> result = new ArrayList<>();

        for (List<T> l: lists)
            result.addAll(l);

        return Collections.unmodifiableList(result);
    }

    public static<T> Set<T> concatUnmodificable(Set<T>... sets) { // todo: to setUtils
        Set<T> result = new HashSet<>();

        for (Set<T> l: sets)
            result.addAll(l);

        return Collections.unmodifiableSet(result);
    }
}
