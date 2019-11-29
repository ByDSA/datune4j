package es.danisales.datune.midi;

import es.danisales.datune.diatonic.ChordNotation;
import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.IntervalDiatonic;
import es.danisales.datune.midi.Settings.DefaultValues;
import es.danisales.datune.midi.pitch.PitchDiatonicMidi;
import es.danisales.datune.midi.pitch.PitchMidiException;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicChordCommon;
import es.danisales.datune.pitch.PitchDiatonic;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import es.danisales.datune.tonality.TonalityChordRetrieval;
import es.danisales.datune.tonality.TonalityException;
import es.danisales.utils.MathUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Objects;

public final class DiatonicChordMidi extends ChordMidi<DiatonicMidi, IntervalDiatonic, PitchDiatonicMidi> implements PitchDiatonic, DiatonicChordCommon<DiatonicMidi> {
    protected Tonality tonality;

    public static DiatonicChordMidiBuilder builder() {
        return new DiatonicChordMidiBuilder();
    }

    protected DiatonicChordMidi() {
    }

    protected DiatonicChordMidi(@NonNull Tonality t) {
        tonality = t;
    }

    // todo: move builder
    public DiatonicChordMidi(Tonality ton, ChromaticChord ns) {
        tonality = ton;
/*
        if ( ns instanceof ChordMidi )
            meta = ( (ChordMidi) ns ).meta;
*/
        try {
            for (Chromatic chromatic : ns) {
                ChromaticMidi cm = ChromaticMidi.builder()
                        .pitch(chromatic)
                        .length(DefaultValues.LENGTH_CHORD)
                        .build();
                add( cm );
            }
        } catch ( TonalityException e ) {
            clear();

            tonality = TonalityChordRetrieval.searchInModeSameRoot(tonality, ns);

            if ( tonality == null )
                throw new RuntimeException();

            try {
                ChromaticChordMidi c = ChromaticChordMidi.builder().fromChromatic(ns).build();
                addAll(c);
            } catch (TonalityException | PitchMidiException e1) {
                throw new RuntimeException();
            }
        }

        setRootIndex(ns.getRootIndex());

        rootIndex = ns.getRootIndex();
/*
        if ( ns instanceof ChordMidi ) {
            arpegio = ( (ChordMidi) ns ).arpegio;
            length = ( (ChordMidi) ns ).length;
        }
*/
        setArpegioIfNull();
    }

    public void add(ChromaticMidi chromaticMidi) throws TonalityException {
        DiatonicMidi diatonicMidi = DiatonicMidi.builder()
                .from(chromaticMidi, tonality)
                .build();
        add(diatonicMidi);
    }

    public boolean addAll(@NonNull Iterable<ChromaticMidi> chromaticMidis) throws AddedException, TonalityException {
        for (ChromaticMidi chromaticMidi : chromaticMidis) {
            add(chromaticMidi);
        }

        return true;
    }

    public void setTonality(@NonNull Tonality tonality) {
        this.tonality = Objects.requireNonNull(tonality);

        for ( DiatonicMidi n : this )
            n.getPitch().setTonality(tonality);
    }

    public void setScaleAsMinor() {
        Tonality newTonality = Tonality.from(tonality.getRoot(), Scale.MINOR);
        setTonality(newTonality);
    }

    public void setScaleAsMajor() {
        Tonality newTonality = Tonality.from(tonality.getRoot(), Scale.MAJOR);
        setTonality( newTonality );
    }

    @Override
    public boolean add(@NonNull DiatonicMidi n) throws AddedException {
        super.add( n );

        setArpegioIfNull();

        return true;
    }

    public void addInterval(@NonNull IntervalDiatonic interval) throws AddedException {
        Objects.requireNonNull(interval);

        DiatonicDegree rootDegree = getRoot().getPitch().getDegree();
        DiatonicDegree targetDegree = DiatonicDegree.add(rootDegree, interval);
        add(targetDegree);
    }

    public void add(@NonNull DiatonicDegree diatonicDegree) throws AddedException {
        PitchDiatonicMidi lastDiatonicPitch = get(size() - 1).pitch;
        PitchDiatonicMidi newDiatonicPitch = lastDiatonicPitch.clone();
        newDiatonicPitch.setDegree(diatonicDegree);
        if (lastDiatonicPitch.getDegree().ordinal() > newDiatonicPitch.getDegree().ordinal())
            newDiatonicPitch.shiftOctave(1);

        DiatonicMidi ns = DiatonicMidi.builder()
                .pitch(newDiatonicPitch)
                .build();
        add( ns );
        setRootIndex(0);
    }

    public Tonality getTonality() {
        return tonality;
    }

    // todo
    @Override
    public void shift(IntervalDiatonic interval) {

    }

    // todo
    @Override
    public void shiftNegative(IntervalDiatonic interval) {

    }

    @Override
    public String toString() {
        if ( size() == 0 )
            return ChordNotation.EMPTY_CHORD;
        else if ( size() == 1 )
            return get( 0 ).toString();
        else {
            return super.toString();
        }
    }

    @NonNull
    @Override
    public DiatonicMidi getCyclic(int noteNumber) {
        DiatonicMidi n;

        int num = MathUtils.rotativeTrim(noteNumber, size());
        n = get(num);

        if (noteNumber >= size()) {
            int octaves = noteNumber / size();
            int index = octaves * IntervalDiatonic.OCTAVE.ordinal();
            n.getPitch().shift(index);
        } else if (noteNumber < 0) {
            int octaves = noteNumber / size() - 1;
            int index = -octaves * IntervalDiatonic.OCTAVE.ordinal();
            n.getPitch().shift(index);
        } else
            n = get(num).clone();

        return n;
    }

    @Override
    public @NonNull DiatonicChordMidi clone() {
        DiatonicChordMidi diatonicChordMidi = (DiatonicChordMidi) commonClone(new DiatonicChordMidi());
        diatonicChordMidi.tonality = tonality.clone();
        diatonicChordMidi.rootIndex = getRootIndex();

        return diatonicChordMidi;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DiatonicChordMidi))
            return false;

        DiatonicChordMidi dcm = (DiatonicChordMidi) o;

        return super.equals(dcm)
                && tonality.equals(dcm.tonality);
    }

    // todo

    /*
    @Override
    public int hashCode() {
        return 47 * ( super.hashCode() + );
    }*/
}
