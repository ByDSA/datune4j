package es.danisales.datune.degrees.scale;

import es.danisales.utils.MathUtils;
import es.danisales.utils.Utils;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum PentatonicDegree implements ScaleDegree {
	I, II, III, IV, V;

    @Override
    public PentatonicDegree getShifted(int i) {
        i = MathUtils.rotativeTrim(i, values().length);
        return values()[i];
    }

    @NonNull
    @Override
    public PentatonicDegree getPrevious() {
        int index = Utils.rotativeTrimLowerOnce(ordinal() - 1, values().length);

        return values()[index];
    }

    @NonNull
    @Override
    public PentatonicDegree getNext() {
        int index = ordinal() + 1;
        index %= values().length;
        return values()[index];
    }

    @Override
    public String toString() {
        return "Pentatonic ScaleDegree " + super.toString();
    }
}
