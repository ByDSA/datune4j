package es.danisales.utils;

public class MathUtils {
    private MathUtils() {
    }

    public static int rotativeTrim(int n, int max) {
        n %= max;
        if (n < 0)
            n += max;

        return n;
    }
}
