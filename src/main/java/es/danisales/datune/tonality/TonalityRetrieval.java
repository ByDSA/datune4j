package es.danisales.datune.tonality;

import es.danisales.datune.absolutedegree.Diatonic;
import es.danisales.datune.degree.DiatonicDegree;
import es.danisales.datune.midi.DiatonicChordMidi;
import es.danisales.datune.midi.DiatonicChordMidiBuilder;
import es.danisales.datune.midi.DiatonicChordMidiInfo;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicAlt;
import es.danisales.datune.musical.DiatonicAltRetrieval;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;

public class TonalityRetrieval {
    private TonalityRetrieval() {
    }

    private static final Set<Tonality> mainMajorTonalities = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
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

    private static final Set<Tonality> mainMinorTonalities = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
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

    private static final Set<Tonality> mainMajorAndMinorTonalities = Collections.unmodifiableSet(
            Stream.concat(mainMajorTonalities.stream(), mainMinorTonalities.stream())
                    .collect(Collectors.toSet())
    );

    @SuppressWarnings("WeakerAccess")
    public static @NonNull Set<Tonality> getMainMajorTonalities() {
        return mainMajorTonalities;
    }

    @SuppressWarnings("WeakerAccess")
    public static @NonNull Set<Tonality> getMainMinorTonalities() {
        return mainMinorTonalities;
    }

    public static @NonNull Set<Tonality> getMainMajorAndMinorTonalities() {
        return mainMajorAndMinorTonalities;
    }

    public static @NonNull List<Tonality> allUsualKeys() {
        List<Tonality> ret = new ArrayList<>();
        List<DiatonicAlt> diatonicAltList = DiatonicAltRetrieval.listFromAlterations(1);
        diatonicAltList.sort(Comparator.comparing(DiatonicAlt::getDiatonic));
        for (Scale mode : Scale.allUsualScales())
            for ( DiatonicAlt diatonicAlt : diatonicAltList ) {
                Tonality tonality = Tonality.from( diatonicAlt, mode );
                ret.add(tonality);
            }

        return ret;
    }

    @SuppressWarnings("WeakerAccess")
    public static @NonNull List<Tonality> listFromChordDiatonicFunction(@NonNull ChromaticChord c) {
        List<Tonality> out = new ArrayList<>();
        for (Tonality t : TonalityRetrieval.allUsualKeys()) {
            if (t.containsAll(c))
                out.add( t );
        }

        return out;
    }

    @SuppressWarnings("WeakerAccess")
    public static @Nullable Tonality listFromChordFirst(@NonNull ChromaticChord c) {
        for (Tonality t : TonalityRetrieval.allUsualKeys()) {
            if (t.containsAll(c))
                return t;
        }

        return null;
    }

    @SuppressWarnings("WeakerAccess")
    public static @NonNull List<Tonality> listFromChordAllFunctions(@NonNull ChromaticChord c) {
        List<Tonality> out = new ArrayList<>();
        for (Tonality t : TonalityRetrieval.allUsualKeys()) {
            if (t.hasAsChromaticFunction(c))
                out.add( t );
        }

        return out;
    }

    static @NonNull Tonality fromDiatonicChordMidi(@NonNull DiatonicChordMidi c, @NonNull Tonality base) {
        if ( base.size() != 7 )
            throw new RuntimeException( "No tiene 7 notas la escala" );

        DiatonicAlt[] notesChord = new DiatonicAlt[c.size()];
        for ( int i = 0; i < c.size(); i++ )
            notesChord[i] = c.get(i).getPitch().getDiatonicAlt();

        int posChordCorrector = 7 - c.get(0).getPitch().getDegree().ordinal();

        // Integer posBaseCorrector = base.getDegreeFrom(notesChord[0]);
        int posBaseCorrector = ( Diatonic.from( notesChord[0] ).ordinal()
                - Diatonic.from( base.getRoot() ).ordinal() + 7 ) % 7;

        DiatonicAlt[] tonalityNotes = new DiatonicAlt[7];
        for ( int i = 0; i < 7; i++ ) {
            int pos = ( posBaseCorrector + i ) % DiatonicDegree.values().length;
            DiatonicDegree diatonicDegree = DiatonicDegree.values()[pos];

            boolean notFound = true;
            for ( int j = 0; j < notesChord.length; j++ ) {
                int index = (c.get(j).getPitch().getDegree().ordinal() + posChordCorrector) % base.getScale().size();
                if (index == i) {
                    tonalityNotes[i] = notesChord[j];
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                try {
                    tonalityNotes[i] = base.getNote(diatonicDegree);
                } catch (ScaleDegreeException e) {
                    throw NeverHappensException.make("Las escalas diatónicas tienen todos los DiatonicDegree");
                }
            }
        }

        List<DiatonicAlt> notes = Arrays.asList(tonalityNotes);
        Scale scale = Scale.fromDiatonicAlt(notes);
        return Tonality.from(notesChord[0], scale);
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
            int currentAlts = currentTonality.getDiatonicAlterationsNumber();
            if (currentAlts < minAlts) {
                ret.clear();
                minAlts = currentAlts;
                ret.add(currentTonality);
            } else if (currentAlts == minAlts)
                ret.add(currentTonality);
        }

        return Collections.unmodifiableSet(ret);
    }

    public static @NonNull List<Tonality> getFromChords(boolean outScale, @NonNull List<ChromaticChord> chords) {
        checkArgument(chords.size() > 0);
        List<Tonality> candidates = new ArrayList<>();

        boolean first = true;
        for (ChromaticChord chord : chords) {
            if ( chord.isEmpty() )
                continue;
            ChromaticChord chordCopy = chord.clone();

            List<Tonality> candidatesPrev = candidates;

            do {
                List<DiatonicChordMidiInfo> possibleChords = DiatonicChordMidiBuilder.fromChromaticChord(
                        chordCopy,
                        outScale
                );
                if ( first ) {
                    for (DiatonicChordMidiInfo c : possibleChords) {
                        Tonality t = c.getTonality();
                        if ( !candidates.contains( t ) )
                            candidates.add( t );
                    }
                    first = false;
                } else {
                    candidates = new ArrayList<>();

                    for (DiatonicChordMidiInfo c : possibleChords) {
                        for ( Tonality t : candidatesPrev )
                            if ((c.getTonality().equals(t)
                                    || c.getTonality().isModeOf( t ) )
                                    && !candidates.contains( t ) )
                                candidates.add( t );
                    }
                }

                if ( candidates.isEmpty() ) {
                    chordCopy = ChromaticChord.builder()
                            .fromChromatic(
                                chordCopy.subList(0, chordCopy.size() - 1)
                            ).build();
                }
            } while ( candidates.isEmpty() && !chordCopy.isEmpty() );
        }

        return candidates;
    }
}
