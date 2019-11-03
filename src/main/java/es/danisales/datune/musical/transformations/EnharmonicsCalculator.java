package es.danisales.datune.musical.transformations;

import es.danisales.datune.musical.Chromatic;

import java.util.ArrayList;
import java.util.List;

public class EnharmonicsCalculator {
    private EnharmonicsCalculator() {
    }

    public static List<Chromatic> calculateFrom(Chromatic chromatic) {
        List<Chromatic> tmp = new ArrayList<>();

        Chromatic[] values = Chromatic.class.getEnumConstants();

        for(Chromatic c : values)
            if (chromatic.compareEnharmonicTo(chromatic) == 0)
                tmp.add(c);

        return tmp;
    }
}
