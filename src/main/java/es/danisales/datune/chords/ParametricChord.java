package es.danisales.datune.chords;

import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

public class ParametricChord {
    private Tonality tonality;
    private HarmonicFunction harmonicFunction;

    private ParametricChord() {
    }

    public static @NonNull ParametricChord from(@NonNull Tonality tonality, HarmonicFunction harmonicFunction) {
        ParametricChord parametricChord = new ParametricChord();
        parametricChord.tonality = tonality;
        parametricChord.harmonicFunction = harmonicFunction;
        return parametricChord;
    }

    public Tonality getTonality() {
        return tonality;
    }

    public void setTonality(@NonNull Tonality tonality) {
        this.tonality = tonality;
    }

    public HarmonicFunction getHarmonicFunction() {
        return harmonicFunction;
    }

    public void setHarmonicFunction(@NonNull HarmonicFunction harmonicFunction) {
        this.harmonicFunction = harmonicFunction;
    }

    @Override
    public String toString() {
        return tonality + " " + harmonicFunction;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ParametricChord))
            return false;

        ParametricChord other = (ParametricChord) o;

        return other.getTonality().equals(getTonality()) && other.getHarmonicFunction().equals(getHarmonicFunction());
    }

    @Override
    public int hashCode() {
        return getTonality().hashCode() + getHarmonicFunction().hashCode();
    }
}
