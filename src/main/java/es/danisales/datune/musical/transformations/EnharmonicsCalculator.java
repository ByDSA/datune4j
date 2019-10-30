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
            if (c.isEnharmonicFrom(chromatic))
                tmp.add(c);

        return tmp;
    }

    public static boolean equals(Chromatic chromatic1, Chromatic chromatic2) {
        return chromatic1.intValue() == chromatic2.intValue();
    }
}
