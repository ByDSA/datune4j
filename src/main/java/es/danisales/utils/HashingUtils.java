package es.danisales.utils;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkState;

public class HashingUtils {
    private HashingUtils() {
    }

    private static final int[] PRIME_NUMBERS = new int[]{
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
            101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199
    };

    public static int from(Object... objects) {
        Objects.requireNonNull(objects);
        checkState(objects.length > 0);

        int sum = 0;
        for (Object iObject : objects) {
            if (iObject != null) {
                sum += iObject.hashCode();
            }
        }

        return sum;
    }
}
