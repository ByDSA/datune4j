package es.danisales.datune.midi;

import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.Settings.DefaultValues;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicChordCommon;
import es.danisales.datune.pitch.PitchDiatonic;
import es.danisales.datune.tonality.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.Objects;

public class DiatonicChordMidi extends ChordMidi<DiatonicMidi, IntervalDiatonic, PitchDiatonicMidi> implements PitchDiatonic, DiatonicChordCommon<DiatonicMidi> {
    protected HarmonicFunction function = null;
    public Tonality metaTonality;
    protected Tonality tonality;

    public static DiatonicChordMidiBuilder builder() {
        return new DiatonicChordMidiBuilder();
    }

    public static @NonNull List<DiatonicChordMidi> fromChromaticChord(ChromaticChord chromaticChordMidi, boolean outScale) {
        return DiatonicChordMidiAdapter.fromChromaticChord(chromaticChordMidi, outScale);
    }

    public static DiatonicChordMidi from(List<DiatonicMidi> diatonicMidiList) {
        DiatonicChordMidi diatonicChordMidi = new DiatonicChordMidi();

        diatonicChordMidi.tonality = diatonicMidiList.get(0).getPitch().getTonality();
        diatonicChordMidi.metaTonality = diatonicChordMidi.tonality;
        diatonicChordMidi.addAll(diatonicMidiList);

        return diatonicChordMidi;
    }

    protected DiatonicChordMidi() {
    }

    protected DiatonicChordMidi(@NonNull Tonality t) {
        tonality = t;
        metaTonality = tonality;
    }

    public DiatonicChordMidi(Tonality ton, ChromaticChord ns) {
        tonality = ton;
        metaTonality = ton;
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

            ChromaticChord chromaticChord = ChromaticChord.builder().fromChromatic(ns).build();
            function = ton.getFunctionFrom(chromaticChord);
            if ( function == null ) {
                tonality = TonalityChordRetrieval.searchInModeSameRoot(tonality, ns);
                metaTonality = tonality;
            } else
                tonality = TonalityRetrieval.listFromChord( ns ).get( 0 );

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

    public DiatonicDegree getDegree() {
        DiatonicDegree d = null;
        if ( function instanceof ChromaticFunction )
            d = DiatonicDegree.from((ChromaticFunction)function);
        if ( d == null ) {
            Chromatic c = Chromatic.from( getRoot() );
            try {
                d = (DiatonicDegree) metaTonality.getDegreeFrom(c);
            } catch (TonalityException e) {
                throw new RuntimeException();
            }
        }
        return d;
    }

    public boolean addAll(@NonNull Iterable<ChromaticMidi> chromaticMidis) throws AddedException, TonalityException {
        for (ChromaticMidi chromaticMidi : chromaticMidis) {
            add(chromaticMidi);
        }

        return true;
    }

    public @Nullable DiatonicMidi get(int note, @NonNull List<DiatonicMidi> ns) {
        if ( ns.size() == 0 )
            return null;

        DiatonicMidi n;
        if ( note >= ns.size() ) {
            n = ns.get( note % ns.size() );
            int index = note / ns.size() * IntervalDiatonic.OCTAVE.ordinal();
            IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(index);
            n.getPitch().shift(intervalDiatonic);
        } else if ( note < 0 ) {
            int num = Math.abs( ns.size() + note % ns.size() );
            n = ns.get( num );
            int index = ( note / ns.size() - 1 ) * IntervalDiatonic.OCTAVE.ordinal();
            IntervalDiatonic intervalDiatonic = IntervalDiatonic.fromIndex(index);
            n.getPitch().shift(intervalDiatonic);
        } else {
            n = ns.get( note ).clone();
        }

        return n;
    }

    public void setTonality(@NonNull Tonality tonality) {
        this.tonality = Objects.requireNonNull(tonality);

        for ( DiatonicMidi n : this )
            n.getPitch().setTonality(tonality);

        WhatIsItDiatonicChordMidi.updateWhatIsIt(this);
    }

    public void setMinorScale() {
        Tonality newTonality = Tonality.from(tonality.getRoot(), Scale.MINOR);
        setTonality(newTonality);
    }

    public void setMajorScale() {
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
        RelativeDegree relativeDegree = getRoot().getPitch().getDegree();
        if (!(relativeDegree instanceof DiatonicDegree))
            throw new RuntimeException();

        add(DiatonicDegree.add((DiatonicDegree) relativeDegree, interval));
    }

    public void add(@NonNull DiatonicDegree pos) throws AddedException {
        PitchDiatonicMidi lastPitch =  get(size()-1).pitch;
        PitchDiatonicMidi pitchDiatonicMidi = lastPitch.clone();
        pitchDiatonicMidi.degree = pos;
        if (lastPitch.degree.ordinal() > pitchDiatonicMidi.degree.ordinal())
            pitchDiatonicMidi.shiftOctave(1);
        DiatonicMidi ns = DiatonicMidi.builder()
                .pitch(pitchDiatonicMidi)
                .length(DefaultValues.LENGTH_CHORD)
                .velocity(DefaultValues.VELOCITY)
                .build();
        add( ns );
        setRootIndex(0);
    }

    public Tonality getTonality() {
        return tonality;
    }

    public Tonality getMetatonality() {
        return metaTonality;
    }

    private void updateFunction() {
        function = HarmonicFunction.get(this);
    }

    private void updateFunctionIfNull() {
        if (function == null)
            updateFunction();
    }

    public @NonNull HarmonicFunction getFunction() {
        updateFunctionIfNull();

        return function;
    }

    @Override
    public int getInversionNumber() {
        return -1;
    }

    @Override
    public void shift(IntervalDiatonic interval) {

    }

    @Override
    public void shiftNegative(IntervalDiatonic interval) {

    }

    @Override
    public String toString() {
        if ( size() == 0 )
            return ChordNotation.EMPTY_CHORD;
        else if ( size() == 1 )
            return get( 0 ).toString();

        return null;
    }


    @Override
    public @NonNull DiatonicChordMidi clone() {
        DiatonicChordMidi diatonicChordMidi = (DiatonicChordMidi) commonClone( new DiatonicChordMidi() );
        diatonicChordMidi.tonality = tonality.clone();
        diatonicChordMidi.metaTonality = metaTonality.clone();
        diatonicChordMidi.function = function;
        diatonicChordMidi.rootIndex = getRootIndex();

        return diatonicChordMidi;
    }

    @Override
    public boolean equals(Object o) {
        if ( !( o instanceof DiatonicChordMidi ) )
            return false;

        DiatonicChordMidi dcm = (DiatonicChordMidi) o;

        return super.equals( dcm ) && getFunction().equals( dcm.getFunction() )
                && metaTonality.equals( dcm.metaTonality );
    }

    // todo

    /*
    @Override
    public int hashCode() {
        return 47 * ( super.hashCode() + );
    }*/
}
