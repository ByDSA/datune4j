package es.danisales.datune.musical;

import es.danisales.datune.diatonic.*;
import es.danisales.datune.midi.*;
import es.danisales.datune.musical.transformations.ChromaticAdapter;
import es.danisales.datune.pitch.PitchChromaticChord;
import es.danisales.datune.tonality.Scale;
import es.danisales.datune.tonality.Tonality;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;

public interface ChromaticChordInterface extends PitchChromaticChord<Chromatic> {
    static ChromaticChordInterface from(ChromaticFunction f, Tonality t) {
        ChromaticChordCustom ret = new ChromaticChordCustom();
        if ( f == ChromaticFunction.I || f == ChromaticFunction.II || f == ChromaticFunction.III
                || f == ChromaticFunction.IV || f == ChromaticFunction.V
                || f == ChromaticFunction.VI || f == ChromaticFunction.VII ) {
            DiatonicAlt r = t.getNote( f.getDegree() );
            Chromatic rChromatic = Chromatic.from(r);
            ret.addAll( ChromaticChordRetrieval.whichRootIs( rChromatic, ChromaticChord.CHORDS_MAJOR ) );
        } else if ( f == ChromaticFunction.i || f == ChromaticFunction.ii
                || f == ChromaticFunction.iii
                || f == ChromaticFunction.iv || f == ChromaticFunction.v
                || f == ChromaticFunction.vi || f == ChromaticFunction.vii ) {
            DiatonicAlt r = t.getNote( f.getDegree() );
            Chromatic rChromatic = Chromatic.from(r);
            ret.addAll( ChromaticChordRetrieval.whichRootIs( rChromatic, ChromaticChord.CHORDS_MINOR ) );
        } else if ( f == ChromaticFunction.I0 || f == ChromaticFunction.II0
                || f == ChromaticFunction.III0 || f == ChromaticFunction.IV0
                || f == ChromaticFunction.V0 || f == ChromaticFunction.VI0
                || f == ChromaticFunction.VII0 ) {
            DiatonicAlt r = t.getNote( f.getDegree() );
            Chromatic rChromatic = Chromatic.from(r);
            ret.addAll( ChromaticChordRetrieval.whichRootIs( rChromatic, ChromaticChord.CHORDS_DIMINISHED ) );
        } else if ( f == ChromaticFunction.N6 ) {
            DiatonicAlt base = t.getNote( DiatonicDegree.I );

            DiatonicAlt n1 = base.addSemi( 1 );
            DiatonicAlt n2 = base.addSemi( 5 );
            DiatonicAlt n3 = base.addSemi( 8 );
            Chromatic n1Chromatic = Chromatic.from(n1);
            Chromatic n2Chromatic = Chromatic.from(n2);
            Chromatic n3Chromatic = Chromatic.from(n3);

            ret.addAll( Arrays.asList(n2Chromatic, n3Chromatic, n1Chromatic) ); // Primera inversión
        } else if ( f == ChromaticFunction.I5 || f == ChromaticFunction.II5
                || f == ChromaticFunction.III5 || f == ChromaticFunction.IV5
                || f == ChromaticFunction.V5 || f == ChromaticFunction.VI5
                || f == ChromaticFunction.VII5 ) {
            DiatonicDegree d = f.getDegree();

            DiatonicAlt n = t.getNote( d );
            Chromatic nChromatic = Chromatic.from(n);
            ret.add( nChromatic );
            DiatonicAlt n2 = n.addSemi( IntervalChromatic.PERFECT_FIFTH.getSemitones() );
            Chromatic n2Chromatic = Chromatic.from(n2);
            ret.add( n2Chromatic );
        } else {
            DiatonicMidi n = null;
            switch ( f ) {
                case V_II:
                    t = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V, t
                                    .getRelativeScaleDiatonic( DiatonicDegree.II )
                            ), t
                    );
                    break;
                case V7_II:
                    t = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V7, t
                                    .getRelativeScaleDiatonic( DiatonicDegree.II )
                            ), t
                    );
                    break;
                case V_III:
                    t = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V, t
                                    .getRelativeScaleDiatonic( DiatonicDegree.III )
                            ), t
                    );
                    break;
                case V7_III:
                    t = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V7, t
                                    .getRelativeScaleDiatonic( DiatonicDegree.III )
                            ), t
                    );
                    break;
                case V_IV:
                    t = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V, t
                                    .getRelativeScaleDiatonic( DiatonicDegree.IV )
                            ), t
                    );
                    break;
                case V7_IV:
                    t = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V7, t
                                    .getRelativeScaleDiatonic( DiatonicDegree.IV )
                            ), t
                    );
                    break;
                case V_V:
                    t = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V, t
                                    .getRelativeScaleDiatonic( DiatonicDegree.V )
                            ), t
                    );
                    break;
                case V7_V:
                    t = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V7, t
                                    .getRelativeScaleDiatonic( DiatonicDegree.V )
                            ), t
                    );
                    break;
                case V_VI:
                    t = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V, t
                                    .getRelativeScaleDiatonic( DiatonicDegree.VI )
                            ), t
                    );
                    break;
                case V7_VI:
                    t = Tonality.fromDiatonicChordMidi(
                            new DiatonicChordMidi(
                                    DiatonicFunction.V7, t
                                    .getRelativeScaleDiatonic( DiatonicDegree.VI )
                            ), t
                    );
                    break;
                case SUBV7:
                    DiatonicChordMidi c = new DiatonicChordMidi( DiatonicFunction.V7, t );
                    Chromatic chromatic = Chromatic.from(c.get( 0 ));
                    t = Tonality.from(
                            chromatic.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_II:
                    DiatonicChordMidi c2 = new DiatonicChordMidi(
                            ChromaticFunction.V7_II, t
                    );
                    Chromatic chromatic2 = Chromatic.from(c2.get( 0 ));
                    t = Tonality.from(
                            chromatic2.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_III:
                    DiatonicChordMidi c3 = new DiatonicChordMidi(
                            ChromaticFunction.V7_III, t
                    );
                    Chromatic chromatic3 = Chromatic.from(c3.get( 0 ));
                    t = Tonality.from(
                            chromatic3.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_IV:
                    DiatonicChordMidi c4 = new DiatonicChordMidi(
                            ChromaticFunction.V7_IV, t
                    );
                    Chromatic chromatic4 = Chromatic.from(c4.get( 0 ));
                    t = Tonality.from(
                            chromatic4.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_V:
                    DiatonicChordMidi c5 = new DiatonicChordMidi(
                            ChromaticFunction.V7_V, t
                    );
                    Chromatic chromatic5 = Chromatic.from(c5.get( 0 ));
                    t = Tonality.from(
                            chromatic5.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case SUBV7_VI:
                    DiatonicChordMidi c6 = new DiatonicChordMidi(
                            ChromaticFunction.V7_VI, t
                    );
                    Chromatic chromatic6 = Chromatic.from(c6.get( 0 ));
                    t = Tonality.from(
                            chromatic6.addSemi( 6 ), Scale.LYDIAN_b7
                    );
                    break;
                case V7ALT:
                    DiatonicChordMidi calt = new DiatonicChordMidi(
                            DiatonicFunction.V7, t
                    );
                    Chromatic chromaticAlt = Chromatic.from(calt.get( 0 ));
                    t = Tonality.from(
                            chromaticAlt, Scale.SUPERLOCRIAN
                    );
                    break;
            }

            DiatonicFunction f2 = null;
            switch ( f ) {
                case V_II:
                case V_III:
                case V_IV:
                case V_V:
                case V_VI:
                    f2 = DiatonicFunction.I;
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
                    f2 = DiatonicFunction.I7;
                    break; // Ya se ha corregido la escala
            }

            DiatonicChord dc = DiatonicChord.from( f2 );
            PitchChromaticChord<Chromatic> cc = ChromaticChordInterface.from(dc, t);
            ret.addAll( cc );
        }

        return ret;
    }

    static @Nullable ChromaticChordInterface from(DiatonicChord diatonicChord, Tonality tonality) {
        ChromaticChordInterface chromaticChord = new ChromaticChordCustom();
        for (Diatonic diatonic : diatonicChord) {
            Chromatic chromatic = Chromatic.from(diatonic, tonality);
            if (chromatic == null)
                return null;
            chromaticChord.add(chromatic);
        }
        return chromaticChord;
    }

    static ChromaticChordInterface from(DiatonicChordMidi diatonicChordMidi) {
        ChromaticChordMidi chromaticChordMidi = ChromaticChordMidi.from(diatonicChordMidi);
        return ChromaticChordInterface.from(chromaticChordMidi);
    }

    static ChromaticChordInterface from(ChromaticChordMidi chromaticChordMidi) {
        ChromaticChordInterface ret = new ChromaticChordCustom();
        for (ChromaticMidi chromaticMidi : chromaticChordMidi)
            ret.add(Chromatic.from(chromaticMidi));
        return ret;
    }

    static ChromaticChordInterface from(Iterable<Chromatic> c) {
        ChromaticChordInterface ret = new ChromaticChordCustom();
        for (Chromatic chromatic : c)
            ret.add(chromatic);

        return ret;
    }

    default ChromaticChordMidi toMidi(int octave, int length) {
        return toMidi( octave, length, Settings.DefaultValues.VELOCITY );
    }

    default ChromaticChordMidi toMidi(int octave) {
        return toMidi( octave, Settings.DefaultValues.DURATION_CHORD );
    }

    default ChromaticChordMidi toMidi() {
        return toMidi( Settings.DefaultValues.OCTAVE );
    }

    default ChromaticChordMidi toMidi(int octave, int length, int velocity) {
        //resetRootIfNeeded();
        ChromaticChordMidi ccm = ChromaticChordMidi.builder()
                .fromChromatic (this)
                .octaveBase(octave)
                .length(length)
                .velocity(velocity)
                .build();
        return ccm;
    }

    @Override
    default ChromaticChordCustom duplicate() {
        return ChromaticChordCustom.from(this);
    }
}
