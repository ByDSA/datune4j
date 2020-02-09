package es.danisales.datune.degrees.scale;

import es.danisales.utils.MathUtils;
import es.danisales.utils.Utils;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum ChromaticDegree implements ScaleDegree {
    I, bII, II, bIII, III, IV, bV, V, bVI, VI, bVII, VII;

    @NonNull
    @Override
    public ChromaticDegree getPrevious() {
        int index = Utils.rotativeTrimLowerOnce(ordinal() - 1, values().length);

        return values()[index];
    }

    @Override
    public ChromaticDegree getShifted(int i) {
        i = MathUtils.rotativeTrim(i, values().length);
        return values()[i];
    }

    @NonNull
    @Override
    public ChromaticDegree getNext() {
        int index = ordinal() + 1;
        index %= values().length;
        return values()[index];
    }

    @Override
    public String toString() {
        return "Chromatic " + super.toString();
    }
}
