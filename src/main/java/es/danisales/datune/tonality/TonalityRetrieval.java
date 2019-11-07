package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.PitchChromaticChord;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TonalityRetrieval {
    private TonalityRetrieval() {
    }

    static @NonNull List<Tonality> all() {
        List<Tonality> ret = new ArrayList<>();
        for ( Scale mode : Scale.ALL )
            for ( Chromatic chromatic : Chromatic.values() )
                ret.add( Tonality.from( chromatic, mode ) );

        return ret;
    }

    static @NonNull List<Tonality> fromChord(boolean outScale, @NonNull PitchChromaticChord c) {
        List<Tonality> out = new ArrayList<>();
        for ( Tonality t : Tonality.all() ) {
            if ( t.has( outScale, c ) )
                out.add( t );
        }

        return out;
    }

    static @NonNull Tonality fromDiatonicChord(@NonNull DiatonicChordMidi c, @NonNull Tonality base) {
        if ( base.size() != 7 )
            throw new RuntimeException( "No tiene 7 notas la escala" );

        DiatonicAlt[] notesChord = new DiatonicAlt[c.size()];
        for ( int i = 0; i < c.size(); i++ )
            notesChord[i] = c.get( i ).getDiatonicAlt();

        int posChordCorrector = 7 - c.get( 0 ).getDegree().val();

        // Integer posBaseCorrector = base.getDegreeFrom(notesChord[0]);
        Integer posBaseCorrector = ( Diatonic.from( notesChord[0] ).ordinal()
                - Diatonic.from( base.getRoot() ).ordinal() + 7 ) % 7;
        if ( posBaseCorrector == null ) {
            DiatonicAlt chromatic = c.get(0).getDiatonicAlt();
            throw new TonalityException(chromatic, base);
        }

        DiatonicAlt[] tonalityNotes = new DiatonicAlt[7];
        for ( int i = 0; i < 7; i++ ) {
            int pos = ( posBaseCorrector + i ) % DiatonicDegree.values().length;
            DiatonicDegree diatonicDegree = DiatonicDegree.values()[pos];

            boolean notFound = true;
            for ( int j = 0; j < notesChord.length; j++ ) {
                int index = (c.get(j).getDegree().val() + posChordCorrector) % base.getScale().size();
                if (index == i) {
                    tonalityNotes[i] = notesChord[j];
                    notFound = false;
                    break;
                }
            }

            if ( notFound )
                tonalityNotes[i] = base.getNote( diatonicDegree );
        }

        return Tonality.of( notesChord[0], Scale.fromDiatonicAltList( Arrays.asList(tonalityNotes) ) );
    }
}
