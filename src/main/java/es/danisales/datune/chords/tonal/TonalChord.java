package es.danisales.datune.chords.tonal;

import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

public class TonalChord {
    private Tonality tonality;
    private HarmonicFunction harmonicFunction;

    private TonalChord() {
    }

    public static @NonNull TonalChord from(@NonNull Tonality tonality, @NonNull HarmonicFunction harmonicFunction) {
        TonalChord parametricChord = new TonalChord();
        parametricChord.tonality = tonality;
        parametricChord.harmonicFunction = harmonicFunction;
        return parametricChord;
    }

    @SuppressWarnings("WeakerAccess")
    public static TonalChordRetrievalET12 retrieval() {
        return new TonalChordRetrievalET12();
    }

    /* Getters and setters */

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

    /* Object */

    @Override
    public String toString() {
        return tonality + " " + harmonicFunction;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TonalChord))
            return false;

        TonalChord other = (TonalChord) o;

        return other.getTonality().equals(getTonality()) && other.getHarmonicFunction().equals(getHarmonicFunction());
    }

    @Override
    public int hashCode() {
        return getTonality().hashCode() + getHarmonicFunction().hashCode();
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public TonalChord clone() {
        return from(tonality, harmonicFunction);
    }
}
