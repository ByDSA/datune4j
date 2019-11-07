package es.danisales.datune.musical.transformations;

import es.danisales.datune.midi.PitchMidi;
import es.danisales.datune.midi.PitchSingleMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.PitchChromaticSingle;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public class ChromaticAdapter {
    private ChromaticAdapter() {
    }

    public static Chromatic from(@NonNull Diatonic diatonic, Tonality tonality) {
        return Chromatic.from( tonality.getNote(diatonic.getDegree()) );
    }

    public static Chromatic from(PitchMidi pitchMidi) {
        int value = pitchMidi.getCode();
        return Chromatic.from( value % 12 );
    }

    public static Chromatic from(PitchSingleMidi chromaticMidi) {
        return from( chromaticMidi.getPitchMidi() );
    }

    public static Chromatic from(PitchChromaticSingle t) {
        if (t.getClass().equals(PitchMidi.class))
            return from((PitchMidi)t);
        else if (t.getClass().equals(PitchSingleMidi.class))
            return from((PitchSingleMidi) t);
        else if (t.getClass().equals(Chromatic.class))
            return (Chromatic)t;

        throw new RuntimeException("Undefined for class " + t.getClass());
    }
}
