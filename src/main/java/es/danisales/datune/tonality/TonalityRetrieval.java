package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;

public class TonalityRetrieval {
    private TonalityRetrieval() {
    }

    public static @NonNull Set<Tonality> majorMinor() {
        return new HashSet<>( Arrays.asList(
                Tonality.C,
                Tonality.D,
                Tonality.E,
                Tonality.F,
                Tonality.G,
                Tonality.A,
                Tonality.B,
                Tonality.Cm,
                Tonality.Dm,
                Tonality.Em,
                Tonality.Fm,
                Tonality.Gm,
                Tonality.Am,
                Tonality.Bm,
                Tonality.Db,
                Tonality.Eb,
                Tonality.FF,
                Tonality.Gb,
                Tonality.Ab,
                Tonality.Bb,
                Tonality.CCm,
                Tonality.DDm,
                Tonality.Ebm,
                Tonality.FFm,
                Tonality.GGm,
                Tonality.Bbm
        ) );
    }

    static @NonNull List<Tonality> all() {
        List<Tonality> ret = new ArrayList<>();
        List<DiatonicAlt> diatonicAltList = DiatonicAlt.listFromAlterations(1);
        for ( Scale mode : Scale.ALL )
            for ( DiatonicAlt diatonicAlt : diatonicAltList ) {
                Tonality tonality = Tonality.of( diatonicAlt, mode );
                ret.add(tonality);
            }

        return ret;
    }

    public static @NonNull List<Tonality> listFromChord(@NonNull PitchChromaticChord<? extends PitchChromaticSingle> c) {
        List<Tonality> out = new ArrayList<>();
        for ( CustomTonality t : CustomTonality.all() ) {
            if ( t.has( false, c ) )
                out.add( t );
        }

        return out;
    }

    public static @NonNull List<Tonality> listFromChordOutScale(@NonNull PitchChromaticChord<? extends PitchChromaticSingle> c) {
        List<Tonality> out = new ArrayList<>();
        for ( CustomTonality t : CustomTonality.all() ) {
            if ( t.has( true, c ) )
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
