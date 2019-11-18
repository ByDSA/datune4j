package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.midi.ChromaticChordMidi;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.musical.ChromaticChordInterface;
import es.danisales.datune.musical.Diatonic;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.DiatonicAltRetrieval;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;

public class TonalityRetrieval {
    private TonalityRetrieval() {
    }

    private static final Set<Tonality> majorTonalities = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            Tonality.C,
            Tonality.Db,
            Tonality.D,
            Tonality.Eb,
            Tonality.E,
            Tonality.F,
            Tonality.FF,
            Tonality.Gb,
            Tonality.G,
            Tonality.Ab,
            Tonality.A,
            Tonality.Bb,
            Tonality.B
    )));

    private static final Set<Tonality> minorTonalities = Collections.unmodifiableSet( new HashSet<>( Arrays.asList(
            Tonality.Cm,
            Tonality.CCm,
            Tonality.Dm,
            Tonality.DDm,
            Tonality.Ebm,
            Tonality.Em,
            Tonality.Fm,
            Tonality.FFm,
            Tonality.Gm,
            Tonality.GGm,
            Tonality.Am,
            Tonality.Bbm,
            Tonality.Bm
    )));

    private static final List<Tonality> majorMinorTonalities = Collections.unmodifiableList(
            Stream.concat(majorTonalities.stream(), minorTonalities.stream())
            .collect(Collectors.toList())
    );

    public static @NonNull Set<Tonality> mainMajor() {
        return majorTonalities;
    }

    public static @NonNull Set<Tonality> mainMinor() {
        return minorTonalities;
    }

    static @NonNull List<Tonality> majorMinor() {
        return majorMinorTonalities;
    }

    static @NonNull List<Tonality> all() {
        List<Tonality> ret = new ArrayList<>();
        List<DiatonicAlt> diatonicAltList = DiatonicAltRetrieval.listFromAlterations(1);
        for ( Scale mode : Scale.ALL )
            for ( DiatonicAlt diatonicAlt : diatonicAltList ) {
                Tonality tonality = Tonality.from( diatonicAlt, mode );
                ret.add(tonality);
            }

        return ret;
    }

    public static @NonNull List<Tonality> listFromChord(@NonNull PitchChromaticChord<? extends PitchChromaticSingle> c) {
        List<Tonality> out = new ArrayList<>();
        for ( Tonality t : Tonality.all() ) {
            if ( t.has( false, c ) )
                out.add( t );
        }

        return out;
    }

    public static @NonNull List<Tonality> listFromChordOutScale(@NonNull PitchChromaticChord<? extends PitchChromaticSingle> c) {
        List<Tonality> out = new ArrayList<>();
        for ( Tonality t : Tonality.all() ) {
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

        int posChordCorrector = 7 - c.get( 0 ).getDegree().ordinal();

        // Integer posBaseCorrector = base.getDegreeFrom(notesChord[0]);
        int posBaseCorrector = ( Diatonic.from( notesChord[0] ).ordinal()
                - Diatonic.from( base.getRoot() ).ordinal() + 7 ) % 7;

        DiatonicAlt[] tonalityNotes = new DiatonicAlt[7];
        for ( int i = 0; i < 7; i++ ) {
            int pos = ( posBaseCorrector + i ) % DiatonicDegree.values().length;
            DiatonicDegree diatonicDegree = DiatonicDegree.values()[pos];

            boolean notFound = true;
            for ( int j = 0; j < notesChord.length; j++ ) {
                int index = (c.get(j).getDegree().ordinal() + posChordCorrector) % base.getScale().size();
                if (index == i) {
                    tonalityNotes[i] = notesChord[j];
                    notFound = false;
                    break;
                }
            }

            if ( notFound )
                tonalityNotes[i] = base.getNote( diatonicDegree );
        }

        return Tonality.from( notesChord[0], Scale.from( Arrays.asList(tonalityNotes) ) );
    }

    @SuppressWarnings("WeakerAccess")
    public static @NonNull Set<Tonality> getEnharmonicFrom(@NonNull Tonality tonality, int maxAlterations) {
        Set<Tonality> ret = new HashSet<>();
        Set<DiatonicAlt> possibleRootList = DiatonicAltRetrieval.getEnharmonicsFrom(tonality.getRoot(), maxAlterations);

        for (DiatonicAlt diatonicAlt : possibleRootList) {
            Tonality currentTonality = Tonality.from(diatonicAlt, tonality.getScale());
            ret.add(currentTonality);
        }

        return Collections.unmodifiableSet(ret);
    }

    public static @NonNull Set<Tonality> getEnharmonicMinimalAltsFrom(@NonNull Tonality tonalityBase) {
        Set<Tonality> ret = new HashSet<>();

        Set<Tonality> enharmonicTonalities = getEnharmonicFrom(tonalityBase, 3);

        int minAlts = Integer.MAX_VALUE;
        for (Tonality currentTonality : enharmonicTonalities) {
            int currentAlts = currentTonality.getAlterations();
            if (currentAlts < minAlts) {
                ret.clear();
                minAlts = currentAlts;
                ret.add(currentTonality);
            } else if (currentAlts == minAlts)
                ret.add(currentTonality);
        }

        return Collections.unmodifiableSet(ret);
    }

    public static List<Tonality> getFromChord(ChromaticChordInterface c) {
        return getFromChord( false, c );
    }

    public static List<Tonality> getFromChordOutScale(ChromaticChordInterface c) {
        return getFromChord(true, c);
    }

    public static List<Tonality> getFromChord(boolean outScale, ChromaticChordInterface c) {
        List<Tonality> out = new ArrayList<>();
        for ( TonalityEnum t : TonalityEnum.values() ) {
            if ( t.has( outScale, c ) )
                out.add( t );
        }

        return out;
    }

    public static List<Tonality> getFromChords(boolean outScale, @NonNull List<ChromaticChordMidi> chords) {
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
                                    || c.getTonality().isModeOf( t ) )
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
