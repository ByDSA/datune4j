package es.danisales.datune.chords;

import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.function.DiatonicFunction;
import es.danisales.datune.function.HarmonicFunction;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;

public class ChromaticChordRetrieval {
    private ChromaticChordRetrieval() {
    }

    public static EnumSet<ChromaticChordEnum> getChordsWithRepeatedNotes() {
        EnumSet<ChromaticChordEnum> chords = EnumSet.noneOf(ChromaticChordEnum.class);
        for (ChromaticChordEnum cc : ChromaticChordEnum.values()) {
            EnumMap<Chromatic, Integer> e = new EnumMap<>( Chromatic.class );
            for (Chromatic c : Chromatic.values())
                e.put( c, 0 );
            for (Chromatic c : cc) {
                Integer i = e.get( c );
                if (i > 0)
                    chords.add( cc );
                e.put( c, i+1 );
            }
        }

        return chords;
    }

    public @Nullable Set<ChromaticChord> getModalChords(@NonNull ChromaticChord chromaticChordBase, @NonNull Tonality tonalityBase) {
        HarmonicFunction f = tonalityBase.getFunctionFrom(chromaticChordBase);
        if ( !(f instanceof DiatonicFunction) )
            return null;

        DiatonicFunction diatonicFunction = (DiatonicFunction) f;
        List<Tonality> tonalitiesSameRoot = tonalityBase.getModesSameRoot();

        Set<ChromaticChord> ret = new HashSet<>();
        for ( Tonality tonality : tonalitiesSameRoot ) {
            ChromaticChord chromaticChord = ChromaticChord.builder()
                    .tonality(tonality)
                    .diatonicFunction(diatonicFunction)
                    .build();
            ret.add(chromaticChord);
        }

        return ret;
    }

    public static @Nullable ChromaticChord whichRootIs(@NonNull Chromatic chromatic, @NonNull Set<ChromaticChord> pcc) {
        for (ChromaticChord chord : pcc)
            if (chord.getRoot() == chromatic)
                return chord;

        return null;
    }

    public static boolean hasSameNotes(ChromaticChord chromaticChord, PitchChromaticChord<Chromatic> chord) {
        EnumSet<Chromatic> e = EnumSet.noneOf( Chromatic.class );
        e.addAll(chromaticChord);

        EnumSet<Chromatic> ee = EnumSet.noneOf( Chromatic.class );
        ee.addAll(chord);

        return e.equals( ee );
    }
}
