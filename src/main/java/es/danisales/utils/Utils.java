package es.danisales.utils;

public class Utils { // todo: to datils
    public static int bound(int x, int a, int b) {
        if (x < a)
            return a;
        else if (x > b)
            return b;
        else
            return x;
    }

    public static int rotativeTrimLowerOnce(int i, int n) {
        if (i < 0)
            i += n;

        return i;
    }
}
