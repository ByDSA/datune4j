package es.danisales.datune.midi;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.Settings.DefaultValues;
import es.danisales.datune.musical.*;
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

            add( c );
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

    protected void chromaticFunctionProcess(ChromaticFunction t, int octave) {
        if ( t == ChromaticFunction.N6 ) {
            ChromaticChordInterface cc = ChromaticChordInterface.from( t, tonality );

            tonality = TonalityRetrieval.listFromChord( cc ).get( 0 );

            ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.builder()
                    .fromChromatic (cc)
                    .octaveBase(octave)
                    .length(length)
                    .build();

            add( chromaticChordMidi );
        } else if ( ArrayUtils.contains( t, ChromaticFunction.POWER_CHORDS ) ) {
            DiatonicDegree d = t.getDegree();

            IntervalChromatic ic = tonality.getInterval( d, IntervalDiatonic.FIFTH );

            if ( !ic.equals( IntervalChromatic.PERFECT_FIFTH ) ) {
                DiatonicAlt diatonicAlt = tonality.getNote( d );
                tonality = Tonality.from( diatonicAlt, Scale.MAJOR );
                d = DiatonicDegree.I;
            }

            ChromaticMidi n = ChromaticMidi.builder()
                    .pitch( tonality.getNote( d ), octave )
                    .length(DefaultValues.LENGTH_CHORD)
                    .build();
            add( n );
            ChromaticMidi n2 = n.clone();
            n2.getPitch().shift(IntervalChromatic.PERFECT_FIFTH);
            //assert !n.equalsEnharmonic( n2 ) : n2;
            add( n2 );
        } else if ( ArrayUtils.contains( t, ChromaticFunction.TENSIONS ) ) {
            DiatonicMidi n = null;
            switch ( t ) {
                case V_II:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.II)
                                    ).build(), tonality
                    );
                    break;
                case V7_II:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V7, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.II)
                                    ).build(), tonality
                    );
                    break;
                case V_III:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.III)
                                    ).build(), tonality
                    );
                    break;
                case V7_III:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V7, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.III)
                                    ).build(), tonality
                    );
                    break;
                case V_IV:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.IV)
                                    ).build(), tonality
                    );
                    break;
                case V7_IV:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V7, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.IV)
                                    ).build(), tonality
                    );
                    break;
                case V_V:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.V)
                                    ).build(), tonality
                    );
                    break;
                case V7_V:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V7, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.V)
                                    ).build(), tonality
                    );
                    break;
                case V_VI:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.VI)
                                    ).build(), tonality
                    );
                    break;
                case V7_VI:
                    tonality = Tonality.fromDiatonicChordMidi(
                            DiatonicChordMidi.builder()
                                    .from(
                                            DiatonicFunction.V7, tonality
                                                    .getRelativeScaleDiatonic(DiatonicDegree.VI)
                                    ).build(), tonality
                    );
                    break;
                case SUBV7:
                    DiatonicChordMidi c = DiatonicChordMidi.builder()
                            .from(DiatonicFunction.V7, tonality)
                            .build();
                    Chromatic firstChromatic = Chromatic.from(c.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_II:
                    DiatonicChordMidi c2 = DiatonicChordMidi.builder()
                            .from(
                                    ChromaticFunction.V7_II, tonality
                            ).build();
                    Chromatic firstChromatic2 = Chromatic.from(c2.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic2.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_III:
                    DiatonicChordMidi c3 = DiatonicChordMidi.builder()
                            .from(
                                    ChromaticFunction.V7_III, tonality
                            ).build();
                    Chromatic firstChromatic3 = Chromatic.from(c3.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic3.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_IV:
                    DiatonicChordMidi c4 = DiatonicChordMidi.builder()
                            .from(
                                    ChromaticFunction.V7_IV, tonality
                            ).build();
                    Chromatic firstChromatic4 = Chromatic.from(c4.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic4.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_V:
                    DiatonicChordMidi c5 = DiatonicChordMidi.builder()
                            .from(
                                    ChromaticFunction.V7_V, tonality
                            ).build();
                    Chromatic firstChromatic5 = Chromatic.from(c5.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic5.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_VI:
                    DiatonicChordMidi c6 = DiatonicChordMidi.builder()
                            .from(
                                    ChromaticFunction.V7_VI, tonality
                            ).build();
                    Chromatic firstChromatic6 = Chromatic.from(c6.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic6.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case V7ALT:
                    DiatonicChordMidi calt = DiatonicChordMidi.builder()
                            .from(
                                    DiatonicFunction.V7, tonality
                            ).build();
                    Chromatic firstChromaticAlt = Chromatic.from(calt.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromaticAlt, Scale.SUPERLOCRIAN
                    );
                    break;
            }

            DiatonicFunction t2 = null;
            switch ( t ) {
                case V_II:
                case V_III:
                case V_IV:
                case V_V:
                case V_VI:
                    t2 = DiatonicFunction.I;
                    break;
                case V7_II:
                case V7_III:
                case V7_IV:
                case V7_V:
                case V7_VI:
                case SUBV7:
                case SUBV7_II:
                case SUBV7_III:
                case SUBV7_IV:
                case SUBV7_V:
                case SUBV7_VI:
                case V7ALT:
                    t2 = DiatonicFunction.I7;
                    break; // Ya se ha corregido la escala
            }
            assert t2 != null : t + " " + metaTonality;

            try {
                diatonicFunctionProcess( t2, octave );
            } catch ( TonalityException e ) {
                System.out.println( t );
            }
        } else {
            ChromaticChordInterface cc = ChromaticChordInterface.from( t, tonality );

            ChromaticMidi[] ccmArray = new ChromaticMidi[cc.size()];
            int i = 0;
            for (Chromatic c : cc) {
                ChromaticMidi cm = ChromaticMidi.builder()
                        .pitch(c)
                        .build();
                ccmArray[i++] = cm;
            }

            ChromaticChordMidi ccm = ChromaticChordMidi.from(ccmArray);

            if ( tonality.has( cc ) )
                add( ccm );
            else {
                metaTonality = TonalityChordRetrieval.searchInModeSameRoot(tonality, cc);
                if ( metaTonality == null )
                    throw new TonalityException( cc, tonality );
                tonality = metaTonality;

                add( ccm );
            }
        }

        sortByPitch();
    }

    void diatonicFunctionProcess(@NonNull DiatonicFunction diatonicFunction, int octave) {
        DiatonicChordPattern diatonicChordPattern = DiatonicChordPattern.from(diatonicFunction);

        add(diatonicChordPattern, octave);
        rootIndex = 0;

        sortByPitch(); // todo: no hace falta
    }

    public void add(DiatonicChordPattern diatonicChordPattern, int octave) {
        for (final Integer diatonic : diatonicChordPattern) {
            DiatonicDegree diatonicDegree = DiatonicDegree.values()[diatonic % Diatonic.NUMBER];
            DiatonicMidi diatonicMidi = DiatonicMidi.builder()
                    .pitch(diatonicDegree, tonality, octave + diatonic / Diatonic.NUMBER)
                    .build();
            add(diatonicMidi);
        }
    }


    public void add(@NonNull ChromaticMidi... chromaticMidis) throws AddedException, TonalityException {
        for (ChromaticMidi chromaticMidi : chromaticMidis) {
            DiatonicMidi diatonicMidi = DiatonicMidi.from(chromaticMidi, tonality);
            if (diatonicMidi == null)
                throw new TonalityException(chromaticMidi.getPitch().getChromatic(), tonality);
            add(diatonicMidi);
        }
    }

    public DiatonicChordMidi add(PitchChromaticChord<? extends ChromaticMidi> ns) throws AddedException {
        for ( int i = 0; i < ns.size(); i++ ) {
            ChromaticMidi n = ns.get( i );
            assert n != null;
            add( n );
        }

        return this;
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
        diatonicChordMidi.tonality = tonality;
        diatonicChordMidi.metaTonality = metaTonality;
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
