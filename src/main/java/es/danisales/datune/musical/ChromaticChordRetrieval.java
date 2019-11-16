package es.danisales.datune.musical;

import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

public class ChromaticChordRetrieval {
    private ChromaticChordRetrieval() {
    }

    public static EnumSet<ChromaticChordEnum> getChordsWithRepeatedNotes() {
        EnumSet<ChromaticChordEnum> chords = EnumSet.noneOf( ChromaticChordEnum.class );
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

    public static <A extends Chord<Chromatic>> boolean hasSameNotesOrder(A notes1, A notes2) {
        if ( notes1.size() != notes2.size() ||  notes1.size() == 0 )
            return false;

        for ( int i = 0; i <  notes1.size(); i++ ) {
            if (  notes1.get( i ) != notes2.get( i ) )
                return false;
        }

        return true;
    }
}
