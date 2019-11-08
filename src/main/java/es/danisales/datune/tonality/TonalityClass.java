package es.danisales.datune.tonality;

import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.pitch.PitchChromaticChord;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class TonalityClass {
    Tonality innerTonality;

    private TonalityClass(Tonality innerTonality) {
        this.innerTonality = innerTonality;
    }

    public static List<TonalityEnum> getFromChord(ChromaticChord c) {
        return getFromChord( false, c );
    }

    public static List<TonalityEnum> getFromChordOutScale(ChromaticChord c) {
        return getFromChord(true, c);
    }

    private static List<TonalityEnum> getFromChord(boolean outScale, ChromaticChord c) {
        List<TonalityEnum> out = new ArrayList<>();
        for ( TonalityEnum t : TonalityEnum.values() ) {
            if ( t.has( outScale, c ) )
                out.add( t );
        }

        return out;
    }

    private static List<Tonality> getFromChords(boolean outScale, @NonNull List<ChromaticChordMidi> chords) {
        checkArgument(chords.size() > 0);
        List<Tonality> candidates = new ArrayList<>();

        boolean first = true;
        for ( ChromaticChordMidi chord : chords ) {
            if ( chord.isEmpty() )
                continue;
            ChromaticChordMidi chordCopy = chord.clone();

            List<Tonality> candidatesPrev = candidates;

            do {
                List<DiatonicChordMidi> possibleChords = chordCopy
                        .toDiatonicChordMidi( outScale );
                if ( first ) {
                    for ( DiatonicChordMidi c : possibleChords ) {
                        Tonality t = c.getTonality();
                        if ( !candidates.contains( t ) )
                            candidates.add( t );
                    }
                    first = false;
                } else {
                    candidates = new ArrayList<>();

                    for ( DiatonicChordMidi c : possibleChords ) {
                        for ( Tonality t : candidatesPrev )
                            if ( ( c.metaTonality.equals( t )
                                    || c.getTonality().isIntercambioModalOf( t ) )
                                    && !candidates.contains( t ) )
                                candidates.add( t );
                    }
                }

                if ( candidates.isEmpty() ) {
                    chordCopy = chordCopy.subList( 0, chordCopy.size() - 1 );
                }
            } while ( candidates.isEmpty() && !chordCopy.isEmpty() );
        }

        return candidates;
    }
}
