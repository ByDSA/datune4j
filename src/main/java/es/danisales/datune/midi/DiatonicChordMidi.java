package es.danisales.datune.midi;

import es.danisales.arrays.ArrayUtils;
import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.Settings.DefaultValues;
import es.danisales.datune.musical.*;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.*;
import es.danisales.datune.tonality.*;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class DiatonicChordMidi extends ChordMidi<DiatonicMidi, DiatonicDegree, IntervalDiatonic> implements PitchDiatonic, DiatonicChordCommon<DiatonicMidi> {
    protected HarmonicFunction	function	= null;
    public Tonality metaTonality;

    protected Tonality tonality;

    protected DiatonicChordMidi() {
    }

    public DiatonicChordMidi(@NonNull Tonality t) {
        tonality = t;
        metaTonality = tonality;
    }

    public DiatonicChordMidi(DiatonicMidi... ns) {
        assert ns.length > 0;
        tonality = ns[0].getTonality();
        metaTonality = tonality;

        for (DiatonicMidi dm : ns)
            add( dm );
    }

    public DiatonicChordMidi(Collection<DiatonicAlt> chord, Tonality tonality, int octave, int length, int velocity) {
        for ( DiatonicAlt n : chord ) {
            DiatonicDegree diatonicDegree = (DiatonicDegree)tonality.getDegreeFrom( n );
            PitchDiatonicMidi pitchDiatonicMidi = PitchDiatonicMidi.from(diatonicDegree, tonality, octave);
            DiatonicMidi cm = DiatonicMidi.builder()
                    .pitch(pitchDiatonicMidi)
                    .length(length)
                    .velocity(velocity)
                    .build();
            Chromatic chromaticCm = Chromatic.from(cm);
            DiatonicMidi lastAdded = get( size() - 1 );
            Chromatic lastChromatic = Chromatic.from( lastAdded );
            if ( size() > 0 && chromaticCm.ordinal() <= lastChromatic.ordinal()) {
                octave++;
                cm.shiftOctave( 1 );
            }

            add( cm );
        }
    }

    public DiatonicChordMidi(HarmonicFunction t, Tonality s) {
        this( t, Settings.DefaultValues.OCTAVE, s );
    }

    public DiatonicChordMidi(HarmonicFunction t, int o, Tonality s) {
        this( t, o, s, Settings.DefaultValues.LENGTH_CHORD);
    }

    public DiatonicChordMidi(HarmonicFunction f, int o, Tonality ton, int len) {
        this( ton );
        length = len;
        function = f;

        if ( ton == null )
            throw new NullPointerException( "El objeto Scale es null" );

        if ( f instanceof ChromaticFunction ) {
            chromaticFunctionProcess( (ChromaticFunction) f, o );
            Chromatic firstChromatic = Chromatic.from( get( 0 ) );
            Chromatic metaChromatic = Chromatic.from( metaTonality.getNote( DiatonicDegree.I ) );
            if ( firstChromatic.ordinal() < metaChromatic.ordinal() )
                shiftOctave( 1 );
        } else if ( f instanceof DiatonicFunction )
            diatonicFunctionProcess( (DiatonicFunction) f, o );
        setArpegioIfNull();
    }

    public boolean hasTonality(Tonality t) {
        return metaTonality.equals( t );
    }

    /*
     * public boolean hasTonality(Tonality[] ts) { for ( Tonality t : ts ) if (
     * hasTonality( t ) ) return true;
     *
     * return false; }
     */
    public static ChromaticChordMidi reduceDistances(ChromaticChordMidi chord) {
        return chord.clone();
    }

    public static ArrayList<ChromaticChordMidi> reduceDistances(final List<ChromaticChordMidi> chords) {
        ArrayList<ChromaticChordMidi> out = new ArrayList<>();
        for ( ChromaticChordMidi c : chords ) {
            out.add( reduceDistances( c ) );
        }

        return out;
    }

    public static void showWhatIsIt(boolean outscale, ChromaticMidi... notes) {
        showWhatIsIt( outscale, () -> {
            return true;
        }, notes );
    }

    public static void showWhatIsIt(ChromaticMidi... notes) {
        showWhatIsIt( false, notes );
    }

    public static void showWhatIsIt(boolean outscale, Supplier<Boolean> f, ChromaticMidi... notes) {
        List<DiatonicChordMidi> chords = ChromaticChordMidi.from( notes )
                .toDiatonicChordMidi( outscale );

        if ( chords.isEmpty() ) {
            System.out.print( "La sucesión de notas no es nada:" );
            for ( ChromaticMidi n : notes ) {
                System.out.print( " " + n );
            }
            System.out.print( "\n" );
        }

        for ( DiatonicChordMidi c : chords )
            if ( f.get() )
                System.out.println(c);
    }

    public static void showPossibleProgressionsMajorMinor(List<ChromaticChordMidi> cs) {
        assert cs != null;
        showPossibleProgressionsMajorMinor( (c) -> {
            return true;
        }, cs );
    }

    public static void showPossibleProgressionsMajorMinor(Function<DiatonicChordMidi, Boolean> f, List<ChromaticChordMidi> cs) {
        assert f != null;
        assert cs != null;
        showPossibleProgressions( (DiatonicChordMidi c) -> {
            return ( c.metaTonality != null && c.metaTonality.isMajorOrMinor()
                    || c.tonality.isMajorOrMinor() ) && f.apply( c );
        }, cs );
    }

    public static void showPossibleProgressions(Function<DiatonicChordMidi, Boolean> f, List<ChromaticChordMidi> chordsIn) {
        List<ChromaticChordMidi> chords = reduceDistances( chordsIn );

        List<Tonality> possibleTonalitiesList = TonalityRetrieval.getFromChords( true, chords );

        // DEBUG
        if ( possibleTonalitiesList == null || possibleTonalitiesList.isEmpty() ) {
            for ( ChromaticChordMidi c : chords ) {
                for ( ChromaticMidi chromaticMidi : c )
                    System.out.print( chromaticMidi + "  " );
                System.out.println();
            }
        }

        assert possibleTonalitiesList != null
                && !possibleTonalitiesList.isEmpty() : "No se ha encontrado escala";

        // Mostrar por consola
        for ( Tonality tonality : possibleTonalitiesList ) {
            if ( tonality.isMajorOrMinor() ) {
                StringBuilder sb = new StringBuilder();
                boolean yep = true;
                boolean first = false;
                sb.append( "----" + tonality + "----" );
                for ( ChromaticChordMidi chromaticMidis : chords ) {
                    DiatonicChordMidi c = new DiatonicChordMidi( tonality, chromaticMidis );
                    if ( !f.apply( c ) ) {
                        yep = false;
                        break;
                    }

                    sb.append( "\n" + c );
                    first = false;
                }

                if ( yep )
                    System.out.println( sb );

            }
        }
    }

    public boolean hasScale(Scale s) {
        return metaTonality.getScale().equals( s );
    }

    public boolean isTonic() {
        return function == DiatonicFunction.I || function == DiatonicFunction.III
                || function == DiatonicFunction.VI;
    }

    public boolean isSubdominant() {
        for ( DiatonicMidi n : this )
            if ( n.getDegree() == DiatonicDegree.IV )
                return true;
        return false;
    }

    public boolean isDominant() {
        function = getFunction();
        return function == DiatonicFunction.V || function == DiatonicFunction.VII;
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

    public DiatonicChordMidi assign(DiatonicChordMidi c) {
        assert c != null;
        super.assign( c );
        tonality = c.tonality;
        this.function = c.function;
        this.metaTonality = c.metaTonality;

        return this;
    }

    public static ArrayList<DiatonicChordMidi> chordsWhereTonalityIs(ArrayList<DiatonicChordMidi> in, Tonality t, boolean meta, boolean intercambioModal) {
        ArrayList<DiatonicChordMidi> cs = new ArrayList<>();
        ArrayList<DiatonicChordMidi> csModal = new ArrayList<>();

        for ( final DiatonicChordMidi i : in )
            if ( meta && i.metaTonality.equals( t ) || !meta && i.getTonality().equals( t ) ) {
                cs.add( i );
            } else if ( intercambioModal && i.metaTonality.isModeOf( t ) )
                csModal.add( i );

        if ( cs.isEmpty() )
            return csModal;
        else
            return cs;
    }

    public static DiatonicChordMidi chordWhereTonalityIs(ArrayList<DiatonicChordMidi> in, Tonality t, boolean meta, boolean intercambioModal) {
        ArrayList<DiatonicChordMidi> cs = chordsWhereTonalityIs( in, t, meta, intercambioModal );
        if ( cs.size() == 0 )
            throw new RuntimeException( "No hay un acorde" );

        return cs.get( 0 );
    }

    private void chromaticFunctionProcess(ChromaticFunction t, int octave) {
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
            n2.shift( IntervalChromatic.PERFECT_FIFTH );
            //assert !n.equalsEnharmonic( n2 ) : n2;
            add( n2 );
        } else if ( ArrayUtils.contains( t, ChromaticFunction.TENSIONS ) ) {
            DiatonicMidi n = null;
            switch ( t ) {
                case V_II:
                    tonality = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V, tonality
                                    .getRelativeScaleDiatonic( DiatonicDegree.II )
                            ), tonality
                    );
                    break;
                case V7_II:
                    tonality = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V7, tonality
                                    .getRelativeScaleDiatonic( DiatonicDegree.II )
                            ), tonality
                    );
                    break;
                case V_III:
                    tonality = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V, tonality
                                    .getRelativeScaleDiatonic( DiatonicDegree.III )
                            ), tonality
                    );
                    break;
                case V7_III:
                    tonality = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V7, tonality
                                    .getRelativeScaleDiatonic( DiatonicDegree.III )
                            ), tonality
                    );
                    break;
                case V_IV:
                    tonality = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V, tonality
                                    .getRelativeScaleDiatonic( DiatonicDegree.IV )
                            ), tonality
                    );
                    break;
                case V7_IV:
                    tonality = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V7, tonality
                                    .getRelativeScaleDiatonic( DiatonicDegree.IV )
                            ), tonality
                    );
                    break;
                case V_V:
                    tonality = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V, tonality
                                    .getRelativeScaleDiatonic( DiatonicDegree.V )
                            ), tonality
                    );
                    break;
                case V7_V:
                    tonality = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V7, tonality
                                    .getRelativeScaleDiatonic( DiatonicDegree.V )
                            ), tonality
                    );
                    break;
                case V_VI:
                    tonality = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V, tonality
                                    .getRelativeScaleDiatonic( DiatonicDegree.VI )
                            ), tonality
                    );
                    break;
                case V7_VI:
                    tonality = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V7, tonality
                                    .getRelativeScaleDiatonic( DiatonicDegree.VI )
                            ), tonality
                    );
                    break;
                case SUBV7:
                    DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.V7, tonality );
                    Chromatic firstChromatic = Chromatic.from(c.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_II:
                    DiatonicChordMidi c2 = new DiatonicChordMidi(
                            ChromaticFunction.V7_II, tonality
                    );
                    Chromatic firstChromatic2 = Chromatic.from(c2.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic2.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_III:
                    DiatonicChordMidi c3 = new DiatonicChordMidi(
                            ChromaticFunction.V7_III, tonality
                    );
                    Chromatic firstChromatic3 = Chromatic.from(c3.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic3.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_IV:
                    DiatonicChordMidi c4 = new DiatonicChordMidi(
                            ChromaticFunction.V7_IV, tonality
                    );
                    Chromatic firstChromatic4 = Chromatic.from(c4.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic4.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_V:
                    DiatonicChordMidi c5 = new DiatonicChordMidi(
                            ChromaticFunction.V7_V, tonality
                    );
                    Chromatic firstChromatic5 = Chromatic.from(c5.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic5.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_VI:
                    DiatonicChordMidi c6 = new DiatonicChordMidi(
                            ChromaticFunction.V7_VI, tonality
                    );
                    Chromatic firstChromatic6 = Chromatic.from(c6.get( 0 ) );
                    tonality = Tonality.from(
                            firstChromatic6.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case V7ALT:
                    DiatonicChordMidi calt = new DiatonicChordMidi(
                            DiatonicFunction.V7, tonality
                    );
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

    private void diatonicFunctionProcess(DiatonicFunction t, int octave) {
        assert t != null;
        DiatonicChord dt = DiatonicChord.from( t );

        add( dt, octave );
        rootIndex = 0;

        sortByPitch();
    }

    public void add(DiatonicChord dt, int octave) {
        //getAdded( dt.getDiatonicMidi( tonality, octave ) );
    }

    public Boolean isOmitByInterval(IntervalDiatonic i) {
        if ( function == null )
            return false;

        switch ( i ) {
            case THIRD:
                switch ( (DiatonicFunction) function ) {
                    case I7_O3:
                    case II7_O3:
                    case III7_O3:
                    case IV7_O3:
                    case V7_O3:
                    case VI7_O3:
                    case VII7_O3:
                    case I9_O3_O7:
                    case II9_O3_O7:
                    case III9_O3_O7:
                    case IV9_O3_O7:
                    case V9_O3_O7:
                    case VI9_O3_O7:
                    case VII9_O3_O7:
                        return true;
                }
                break;
            case FIFTH:
                switch ( (DiatonicFunction) function ) {
                    case I_THIRD:
                    case II_THIRD:
                    case III_THIRD:
                    case IV_THIRD:
                    case V_THIRD:
                    case VI_THIRD:
                    case VII_THIRD:
                    case I_SECOND:
                    case II_SECOND:
                    case III_SECOND:
                    case IV_SECOND:
                    case V_SECOND:
                    case VI_SECOND:
                    case VII_SECOND:
                    case I_FOURTH:
                    case II_FOURTH:
                    case III_FOURTH:
                    case IV_FOURTH:
                    case V_FOURTH:
                    case VI_FOURTH:
                    case VII_FOURTH:
                    case I6_O5:
                    case II6_O5:
                    case III6_O5:
                    case IV6_O5:
                    case V6_O5:
                    case VI6_O5:
                    case VII6_O5:
                    case I7_O5:
                    case II7_O5:
                    case III7_O5:
                    case IV7_O5:
                    case V7_O5:
                    case VI7_O5:
                    case VII7_O5:
                        return true;
                }
                break;
            case ELEVENTH:
                break;
            case FIFTEENTH:
                break;
            case FOURTEENTH:
                break;
            case FOURTH:
                break;
            case NINTH:
                break;
            case OCTAVE:
                break;
            case SECOND:
                break;
            case SEVENTH:
                switch ( (DiatonicFunction) function ) {
                    case I9_O7:
                    case II9_O7:
                    case III9_O7:
                    case IV9_O7:
                    case V9_O7:
                    case VI9_O7:
                    case VII9_O7:
                    case I9_O3_O7:
                    case II9_O3_O7:
                    case III9_O3_O7:
                    case IV9_O3_O7:
                    case V9_O3_O7:
                    case VI9_O3_O7:
                    case VII9_O3_O7:
                        return true;
                }
                break;
            case SIXTH:
                break;
            case TENTH:
                break;
            case THIRTEENTH:
                break;
            case TWELFTH:
                break;
            case UNISON:
                break;
        }

        return false;
    }

    public boolean hasByType(IntervalDiatonic i) {
        if ( function instanceof DiatonicFunction )
            switch ( i ) {
                case SECOND:
                    switch ( (DiatonicFunction) function ) {
                        case I2:
                        case II2:
                        case III2:
                        case IV2:
                        case V2:
                        case VI2:
                        case VII2:
                        case I_SECOND:
                        case II_SECOND:
                        case III_SECOND:
                        case IV_SECOND:
                        case V_SECOND:
                        case VI_SECOND:
                        case VII_SECOND:
                            return true;
                    }
                    break;
                case THIRD:
                    return !( hasByType( IntervalDiatonic.SECOND )
                            || hasByType( IntervalDiatonic.FOURTH ) )
                            && !isOmitByInterval( IntervalDiatonic.THIRD );
                case FOURTH:
                    switch ( (DiatonicFunction) function ) {
                        case I4:
                        case II4:
                        case III4:
                        case IV4:
                        case V4:
                        case VI4:
                        case VII4:
                        case I_FOURTH:
                        case II_FOURTH:
                        case III_FOURTH:
                        case IV_FOURTH:
                        case V_FOURTH:
                        case VI_FOURTH:
                        case VII_FOURTH:
                            return true;
                    }
                    break;
                case FIFTH:
                    return !isOmitByInterval( IntervalDiatonic.FIFTH );
                case SIXTH:
                    switch ( (DiatonicFunction) function ) {
                        case I6:
                        case II6:
                        case III6:
                        case IV6:
                        case V6:
                        case VI6:
                        case VII6:
                        case I6_O5:
                        case II6_O5:
                        case III6_O5:
                        case IV6_O5:
                        case V6_O5:
                        case VI6_O5:
                        case VII6_O5:
                            return true;
                    }
                    break;
                case SEVENTH:
                    switch ( (DiatonicFunction) function ) {
                        case I7:
                        case II7:
                        case III7:
                        case IV7:
                        case V7:
                        case VI7:
                        case VII7:

                        case I7_O5:
                        case II7_O5:
                        case III7_O5:
                        case IV7_O5:
                        case V7_O5:
                        case VI7_O5:
                        case VII7_O5:
                        case I7_O3:
                        case II7_O3:
                        case III7_O3:
                        case IV7_O3:
                        case V7_O3:
                        case VI7_O3:
                        case VII7_O3:

                        case I9:
                        case II9:
                        case III9:
                        case IV9:
                        case V9:
                        case VI9:
                        case VII9:
                        case I11:
                        case II11:
                        case III11:
                        case IV11:
                        case V11:
                        case VI11:
                        case VII11:
                            return true;
                    }
                    break;
                case NINTH:
                    switch ( (DiatonicFunction) function ) {
                        case I9:
                        case II9:
                        case III9:
                        case IV9:
                        case V9:
                        case VI9:
                        case VII9:
                        case I9_O7:
                        case II9_O7:
                        case III9_O7:
                        case IV9_O7:
                        case V9_O7:
                        case VI9_O7:
                        case VII9_O7:
                        case I9_O3_O7:
                        case II9_O3_O7:
                        case III9_O3_O7:
                        case IV9_O3_O7:
                        case V9_O3_O7:
                        case VI9_O3_O7:
                        case VII9_O3_O7:
                        case I11:
                        case II11:
                        case III11:
                        case IV11:
                        case V11:
                        case VI11:
                        case VII11:
                            return true;
                    }
                case ELEVENTH:
                    switch ( (DiatonicFunction) function ) {
                        case I11:
                        case II11:
                        case III11:
                        case IV11:
                        case V11:
                        case VI11:
                        case VII11:
                            return true;
                    }
                case THIRTEENTH:
                    switch ( (DiatonicFunction) function ) {
                        case I13:
                        case II13:
                        case III13:
                        case IV13:
                        case V13:
                        case VI13:
                        case VII13:
                            return true;
                    }
            }
        else
            throw new RuntimeException( function + " " + metaTonality );

        return false;
    }

    public boolean add(ChromaticMidi... ns) throws AddedException, TonalityException {
        assert tonality != null;
        assert ns != null;
        for ( ChromaticMidi n : ns ) {
            DiatonicMidi diatonicMidi = DiatonicMidi.builder()
                    .fromChromatic(n, tonality)
                    .build();
            add(diatonicMidi);
        }

        return true;
    }

    public DiatonicChordMidi add(PitchChromaticChord<? extends ChromaticMidi> ns) throws AddedException {
        for ( int i = 0; i < ns.size(); i++ ) {
            ChromaticMidi n = ns.get( i );
            assert n != null;
            add( n );
        }

        return this;
    }

    public DiatonicChordMidi addDuplicate(int oct) {
        if ( oct == 0 )
            throw new AddedException( this );

        int sizeIni = size();
        for ( int i = 0; i < sizeIni; i++ ) {
            DiatonicMidi n = get( i ).clone();
            n.shiftOctave( oct );
            add( n );
        }

        return this;
    }

    public static boolean contains(List<DiatonicChordMidi> chords, boolean sameOctave, boolean sameTonality, DiatonicChordMidi c) {
        for ( DiatonicChordMidi ccc : chords )
            if ( sameTonality && ccc.isSameChordNotesAndTonality( sameOctave, c )
                    || !sameTonality && ccc.hasSameNotesOrder( sameOctave, c ) )
                return true;

        return false;
    }

    public boolean isSameChordNotesAndTonality(boolean sameOctave, DiatonicChordMidi notes) {
        return hasSameNotesOrder( sameOctave, notes ) && tonality.equals( notes.tonality );
    }

    public DiatonicMidi get(int note, List<DiatonicMidi> ns) {
        if ( ns.size() == 0 )
            return null;

        DiatonicMidi n;
        if ( note >= ns.size() ) {
            n = ns.get( note % ns.size() );
            IntervalDiatonic i = IntervalDiatonic.fromIndex( note / ns.size() * IntervalDiatonic.OCTAVE.ordinal() );
            n.add( i );
        } else if ( note < 0 ) {
            int num = Math.abs( ns.size() + note % ns.size() );
            n = ns.get( num );
            IntervalDiatonic i = IntervalDiatonic.fromIndex( ( note / ns.size() - 1 ) * IntervalDiatonic.OCTAVE.ordinal() );
            n.add( i );
        } else {
            n = ns.get( note ).clone();
        }

        return n;
    }

    public boolean hasMainTriadType() {
        return ( function == DiatonicFunction.I || function == DiatonicFunction.II
                || function == DiatonicFunction.III || function == DiatonicFunction.IV
                || function == DiatonicFunction.V || function == DiatonicFunction.VI
                || function == DiatonicFunction.VII );
    }

    @Override
    public DiatonicChordMidi clone() {
        DiatonicChordMidi c = new DiatonicChordMidi( tonality );
        c.length = length;
        c.metaTonality = metaTonality;
        c.function = function;

        if ( arpegio != null )
            c.arpegio = arpegio.clone();
        for ( DiatonicMidi n : this )
            c.add( n.clone() );

        c.rootIndex = getRootPos();

        return c;
    }

    public ArrayList<ChromaticMidi> commonNotes(DiatonicChordMidi c) {
        return commonNotes( c, false );
    }

    public ArrayList<ChromaticMidi> commonNotes(DiatonicChordMidi c, boolean sameOctave) {
        ArrayList<ChromaticMidi> ret = new ArrayList<ChromaticMidi>();

        for ( DiatonicMidi nscale1 : this ) {
            ChromaticMidi n1 = ChromaticMidi.from(nscale1);
            for ( DiatonicMidi nscale2 : c ) {
                ChromaticMidi n2 = ChromaticMidi.from(nscale2);

                if ( n1.pitch.getCode() == n2.pitch.getCode() )
                    ret.add( n2 );
                else  {
                    Chromatic chromaticn1 = Chromatic.from(n1);
                    Chromatic chromaticn2 = Chromatic.from(n2);
                    if ( sameOctave && chromaticn1 == chromaticn2 )
                        ret.add( n2 );
                }
            }
        }

        return ret;
    }

    /*
     * private int correctOctave(NoteScale n) { int diffOctave = octave -
     * n.toNote().getOctave(); if (diffOctave != 0) shiftOctave(diffOctave);
     *
     * return diffOctave; }
     */
    public DiatonicChordMidi relative(DiatonicFunction pos) {
        Tonality s = tonality.getRelativeScaleDiatonic( get( 0 ).getDegree() );
        DiatonicChordMidi c = new DiatonicChordMidi( pos, getOctave(), s );

        return c;
    }

    @Override
    public void shiftOctave(int o) {
        for ( DiatonicMidi n : this )
            n.shiftOctave( o );
    }

    public static ArrayList<DiatonicChordMidi> shiftOctave(ArrayList<DiatonicChordMidi> a, int o) {
        for ( DiatonicChordMidi c : a )
            c.shiftOctave( o );

        return a;
    }

    public static ArrayList<DiatonicChordMidi> duplicate(ArrayList<DiatonicChordMidi> a) {
        ArrayList<DiatonicChordMidi> b = new ArrayList<DiatonicChordMidi>();
        for ( DiatonicChordMidi c : a )
            b.add( (DiatonicChordMidi) c.clone() );

        return b;
    }

    public DiatonicChordMidi setTonality(Tonality s) {
        tonality = s;

        for ( DiatonicMidi n : this )
            n.setTonality( s );

        WhatIsItDiatonicChordMidi.updateWhatIsIt(this);

        return this;
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
    public DiatonicChordMidi duplicate() { // todo
        return null;
    }

    @Override
    public @NonNull DiatonicChordMidi getInv(int i) {
        DiatonicChordMidi diatonicChordMidi = new DiatonicChordMidi();
        diatonicChordMidi.addAll(this);
        diatonicChordMidi.setRootPos( this.getRootPos() );
        diatonicChordMidi.inv(i);
        return diatonicChordMidi;
    }

    @Override
    public @NonNull DiatonicChordMidi getWithRootPos(int i) {
            DiatonicChordMidi diatonicChordMidi = new DiatonicChordMidi();
            diatonicChordMidi.addAll(this);
            diatonicChordMidi.setRootPos( i );
            return diatonicChordMidi;
    }

    public boolean add(@NonNull DiatonicMidi n) throws AddedException {
        boolean r = super.add( n );

        setArpegioIfNull();

        return r;
    }

    public boolean addIfNotExists(DiatonicMidi n) {
        try {
            return add( n );
        } catch ( AddedException e ) {
            return false;
        }
    }

    public DiatonicChordMidi addIntervalIfNotExists(IntervalDiatonic n) {
        try {
            return addInterval( n );
        } catch ( AddedException e ) {
            return this;
        }
    }

    public DiatonicChordMidi addInterval(IntervalDiatonic interval) throws AddedException {
        return add( DiatonicDegree.add( getRoot().getDegree(), interval ) );
    }

    public DiatonicChordMidi add(DiatonicDegree pos) throws AddedException {
        Integer octave = getOctave();
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

        return this;
    }

    public DiatonicMidi getFromBase(int note) {
        List<DiatonicMidi> ns;

        DiatonicChordMidi c = this.clone();
        int inversion = getInversionNumber();
        if ( inversion > 0 )
            c.inv( -inversion );
        ns = c;

        // Quitar notas duplicadas (en diferente octava)
        for ( int i = 0; i < ns.size(); i++ )
            for ( int j = i + 1; j < ns.size(); j++ ) {
                if ( ns.get( i ).getDegree() == ns.get( j ).getDegree() ) {
                    ns.remove( j );
                    j--;
                }
            }

        return get( note, ns );
    }

    public Tonality getTonality() {
        return tonality;
    }

    public Tonality getMetatonality() {
        return metaTonality;
    }

    public ChromaticChordMidi toChromaticChordMidi() {
        ChromaticChordMidi c = new ChromaticChordMidi();
        for ( DiatonicMidi n : this ) {
            ChromaticMidi nChromatic = ChromaticMidi.from(n);
            c.add(nChromatic);
        }
        c.arpegio = arpegio;
        c.length = length;
        c.setRootPos( getRootPos() );

        return c;
    }

    @Override
    public String toString() {
        if ( size() == 0 )
            return ChordNotation.EMPTY_CHORD;
        else if ( size() == 1 )
            return get( 0 ).toString();

        return null;
    }

    protected void updateFunction() {
        function = HarmonicFunction.get( this );
    }

    protected void updateFunctionIfNull() {
        if ( function == null )
            updateFunction();
    }

    public HarmonicFunction getFunction() {
        updateFunctionIfNull();

        assert function != null;

        return function;
    }

    public List integerNotationFromRoot() {
        List<IntervalChromatic> distancesAbsolute = null;

        if ( size() > 0 ) {
            try {
                distancesAbsolute = new ArrayList<>();

                for ( int i = 1; i < size(); i++ ) {
                    DiatonicMidi n1 = get( 0 );
                    DiatonicMidi n2 = get( i );
                    IntervalChromatic d = n1.distInterval( n2 );
                    distancesAbsolute.set( i - 1, d );
                }
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }

        return distancesAbsolute;
    }

    @Override
    public boolean equals(Object o) {
        if ( !( o instanceof DiatonicChordMidi ) )
            return false;

        DiatonicChordMidi dcm = (DiatonicChordMidi) o;

        return super.equals( dcm ) && getFunction().equals( dcm.getFunction() )
                && metaTonality.equals( dcm.metaTonality );
    }

    public ChromaticChordMidi getChromaticChordMidi() {
        return this.toChromaticChordMidi();
    }

    @Override
    public int getInversionNumber() {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    protected DiatonicChordMidi newChord() {
        return new DiatonicChordMidi();
    }

    @Override
    public PitchDiatonic getShifted(IntervalDiatonic intervalDiatonic) {
        return null;
    }

    @Override
    public PitchDiatonic getShiftedNegative(IntervalDiatonic intervalDiatonic) {
        return null;
    }

    @Override
    public void shift(IntervalDiatonic interval) {

    }

    @Override
    public void shiftNegative(IntervalDiatonic interval) {

    }
}
