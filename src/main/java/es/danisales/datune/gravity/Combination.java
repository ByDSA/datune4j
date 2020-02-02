package es.danisales.datune.gravity;

// Source: https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination {
    private Combination() {
    }

    /* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    private static <O> void combinationUtil(List<O> arr, O[] data, int start,
                                            int end, int index, int r, Set<O[]> ret) {
        // Current combination is ready to be printed, print it
        if (index == r)  {
            ret.add(Arrays.copyOf(data, data.length));
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++) {
            data[index] = arr.get(i);
            combinationUtil(arr, data, i+1, end, index+1, r, ret);
        }
    }

    public static <O> Set<O[]> getCombinations(List<O> base) {
        int n = base.size();
        Set<O[]> ret = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            @SuppressWarnings("unchecked")
            O[] data = (O[])Array.newInstance(base.get(0).getClass(), i);

            combinationUtil(base, data, 0, base.size() - 1, 0, i, ret);
        }

        return ret;
    }
}

/* This code is contributed by Devesh Agrawal */

