package es.danisales.datune.gravity;

// Source: https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/

import es.danisales.datune.degrees.octave.Chromatic;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TendenciesCombination {
    private TendenciesCombination() {
    }

    private static void combinationUtil(List<NoteTendency> arr, NoteTendency[] data, int start,
                                        int end, int index, int r, Set<NoteTendency[]> ret) {
        if (index == r)  {
            if (checkValid(data))
                ret.add(Arrays.copyOf(data, data.length));
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++) {
            data[index] = arr.get(i);

            combinationUtil(arr, data, i+1, end, index+1, r, ret);
        }
    }

    private static boolean checkValid(NoteTendency[] data) {
        for (int j = 0; j < data.length; j++) {
            Chromatic indexKey = data[j].getFrom();
            for (int i = 0; i < j; i++) {
                if (data[i].getFrom().equals(indexKey))
                    return false;
            }
        }

        return true;
    }

    public static Set<NoteTendency[]> getCombinations(List<NoteTendency> base) {
        int n = base.size();
        Set<NoteTendency[]> ret = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            @SuppressWarnings("unchecked")
            NoteTendency[] data = new NoteTendency[i];

            combinationUtil(base, data, 0, base.size() - 1, 0, i, ret);
        }

        return ret;
    }
}

/* This code is contributed by Devesh Agrawal */

