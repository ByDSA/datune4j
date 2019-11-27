package es.danisales.datune.midi;

import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.Settings.DefaultValues;
import es.danisales.datune.musical.Chromatic;
import es.danisales.datune.musical.ChromaticAdapter;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.musical.DiatonicChordCommon;
import es.danisales.datune.pitch.Chord;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.pitch.PitchChromaticSingle;
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

    public static @NonNull List<DiatonicChordMidi> fromChromaticChordMidi(ChromaticChordMidi chromaticChordMidi, boolean outScale) {
        return DiatonicChordMidiAdapter.fromChromaticChordMidi(chromaticChordMidi, outScale);
    }

    public static @Nullable DiatonicChordMidi fromChromaticChordMidi(ChromaticChordMidi chromaticChordMidi, Tonality tonality) {
        return DiatonicChordMidiAdapter.fromChromaticChordMidi(chromaticChordMidi, tonality);
    }

    public static DiatonicChordMidi from(List<DiatonicMidi> diatonicMidiList) {
        DiatonicChordMidi diatonicChordMidi = new DiatonicChordMidi();

        diatonicChordMidi.tonality = diatonicMidiList.get(0).getPitch().getTonality();
        diatonicChordMidi.metaTonality = diatonicChordMidi.tonality;
        diatonicChordMidi.addAll(diatonicMidiList);

        return diatonicChordMidi;
    }

    public static DiatonicChordMidi from(ChromaticChord chromaticChord, Tonality tonality) {
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.from(chromaticChord);
        return DiatonicChordMidi.fromChromaticChordMidi(chromaticChordMidi, tonality);
    }

    protected DiatonicChordMidi() {
    }

    protected DiatonicChordMidi(@NonNull Tonality t) {
        tonality = t;
        metaTonality = tonality;
    }

    public <N extends PitchChromaticSingle, Array extends PitchChromaticChord<N>> DiatonicChordMidi(Tonality ton, Array ns) {
        tonality = ton;
        metaTonality = ton;

        if ( ns instanceof ChordMidi )
            meta = ( (ChordMidi) ns ).meta;

        try {
            for (PitchChromaticSingle pcs : ns) {
                Chromatic chromaticPcs = ChromaticAdapter.from(pcs);
                ChromaticMidi cm = ChromaticMidi.builder()
                        .pitch(chromaticPcs)
                        .length(DefaultValues.LENGTH_CHORD)
                        .build();
                add( cm );
            }
        } catch ( TonalityException e ) {
            clear();

            function = ton.getFunctionFrom( ChromaticChord.from(ns) );
            if ( function == null ) {
                tonality = TonalityChordRetrieval.searchInModeSameRoot(tonality, ns);
                metaTonality = tonality;
            } else
                tonality = TonalityRetrieval.listFromChord( ns ).get( 0 );

            if ( tonality == null )
                throw new TonalityException( ns, ton );

            ChromaticChordMidi c = ChromaticChordMidi.from(ns);

            addAll(c);
        }

        Chord c = ( (Chord) ns );
        setRootPos( c.getRootPos() );

        rootIndex = ns.getRootPos();

        if ( ns instanceof ChordMidi ) {
            arpegio = ( (ChordMidi) ns ).arpegio;
            length = ( (ChordMidi) ns ).length;
        }

        setArpegioIfNull();
    }

    public void add(ChromaticMidi chromaticMidi) throws TonalityException {
        DiatonicMidi diatonicMidi = DiatonicMidi.from(chromaticMidi, tonality);
        if (diatonicMidi == null)
            throw new TonalityException(chromaticMidi.getPitch().getChromatic(), tonality);
        add(diatonicMidi);
    }

    @Override
    public DiatonicChordMidi newChord() {
        return new DiatonicChordMidi();
    }

    public boolean isTonic() {
        return function == DiatonicFunction.I || function == DiatonicFunction.III
                || function == DiatonicFunction.VI;
    }

    public boolean isSubdominant() {
        for (DiatonicMidi n : this)
            if (n.getPitch().getDegree() == DiatonicDegree.IV)
                return true;
        return false;
    }

    public boolean isDominant() {
        function = getFunction();
        return function == DiatonicFunction.V || function == DiatonicFunction.VII;
    }

    public DiatonicDegree getDegree() {
        DiatonicDegree d = null;
        if ( function instanceof ChromaticFunction )
            d = ( (ChromaticFunction) function ).getDegree();
        if ( d == null ) {
            Chromatic c = Chromatic.from( getRoot() );
            d = (DiatonicDegree)metaTonality.getDegreeFrom( c );
        }
        return d;
    }

    public boolean addAll(@NonNull Iterable<ChromaticMidi> chromaticMidis) throws AddedException, TonalityException {
        for (ChromaticMidi chromaticMidi : chromaticMidis) {
            add(chromaticMidi);
        }

        return true;
    }

    public DiatonicMidi get(int note, List<DiatonicMidi> ns) {
        if ( ns.size() == 0 )
            return null;

        DiatonicMidi n;
        if ( note >= ns.size() ) {
            n = ns.get( note % ns.size() );
            IntervalDiatonic i = IntervalDiatonic.fromIndex( note / ns.size() * IntervalDiatonic.OCTAVE.ordinal() );
            n.getPitch().shift(i);
        } else if ( note < 0 ) {
            int num = Math.abs( ns.size() + note % ns.size() );
            n = ns.get( num );
            IntervalDiatonic i = IntervalDiatonic.fromIndex( ( note / ns.size() - 1 ) * IntervalDiatonic.OCTAVE.ordinal() );
            n.getPitch().shift(i);
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
        boolean r = super.add( n );

        setArpegioIfNull();

        return r;
    }

    public void addInterval(@NonNull IntervalDiatonic interval) throws AddedException {
        Objects.requireNonNull(interval);
        add(DiatonicDegree.add(getRoot().getPitch().getDegree(), interval));
    }

    public void add(@NonNull DiatonicDegree pos) throws AddedException {
        PitchDiatonicMidi lastPitch =  get(size()-1).pitch;
        PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(lastPitch);
        pitchDiatonicMidi.degree = pos;
        if (lastPitch.degree.ordinal() > pitchDiatonicMidi.degree.ordinal())
            pitchDiatonicMidi.shiftOctave(1);
        DiatonicMidi ns = DiatonicMidi.builder()
                .pitch(pitchDiatonicMidi)
                .length(DefaultValues.LENGTH_CHORD)
                .velocity(DefaultValues.VELOCITY)
                .build();
        add( ns );
        setRootPos( 0 );
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
    public DiatonicChordMidi clone() {
        DiatonicChordMidi diatonicChordMidi = (DiatonicChordMidi) super.clone();
        diatonicChordMidi.tonality = tonality.clone();
        diatonicChordMidi.metaTonality = metaTonality.clone();
        diatonicChordMidi.function = function;
        diatonicChordMidi.rootIndex = getRootPos();

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

    @Override
    public int hashCode() {
        // todo
        return 0;
    }
}
