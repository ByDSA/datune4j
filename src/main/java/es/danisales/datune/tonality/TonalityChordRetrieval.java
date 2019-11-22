package es.danisales.datune.tonality;

import es.danisales.datune.diatonic.DiatonicDegree;
import es.danisales.datune.diatonic.DiatonicFunction;
import es.danisales.datune.diatonic.HarmonicFunction;
import es.danisales.datune.musical.ChromaticChord;
import es.danisales.datune.pitch.PitchChromaticChord;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TonalityChordRetrieval {
    private TonalityChordRetrieval() {
    }

    public static Tonality searchInModeSameRoot(Tonality tonality, PitchChromaticChord c) {
        List<Tonality> ts;
        if ( tonality.getScale().isDiatonic() ) {
            ts = new ArrayList<>();
            ts.add( Tonality.from( tonality.getRoot(), Scale.MAJOR ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.MINOR ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.DORIAN ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.PHRYGIAN ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.LYDIAN ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.MIXOLYDIAN ) );
            ts.add( Tonality.from( tonality.getRoot(), Scale.LOCRIAN ) );
        } else
            ts = tonality.getModesSameRoot();

        for ( Tonality t : ts ) {
            if ( t.equals( tonality ) )
                continue;
            HarmonicFunction function = t.getFunctionFrom(ChromaticChord.from(c) );
            if (function instanceof DiatonicFunction) {
                return t;
            }
        }

        return null;
    }

    public static @Nullable Tonality getRelativeMinorFrom(@NonNull Tonality tonality) {
        return getRelativeFrom(tonality, Scale.MINOR);
    }

    public static @Nullable Tonality getRelativeMajorFrom(@NonNull Tonality tonality) {
        return getRelativeFrom(tonality, Scale.MAJOR);
    }

    private static @Nullable Tonality getRelativeFrom(@NonNull Tonality tonalityBase, @NonNull Scale scale) {
        Objects.requireNonNull(tonalityBase);
        Objects.requireNonNull(scale);

        if (tonalityBase.getScale().equals(scale))
            return tonalityBase;

        List<Tonality> modes = tonalityBase.getModes();
        for ( Tonality tonality : modes )
            if ( tonality.getScale().equals( scale ) )
                return tonality;

        return null;
    }

    public static List<ChromaticChord> getTriadChordsFrom(Tonality tonality) {
        NoDiatonicScaleException.check( tonality.getScale() );
        List<ChromaticChord> ret = new ArrayList<>();
        for ( DiatonicDegree diatonicDegree : DiatonicDegree.values() ) {
            DiatonicFunction f = null;
            switch ( diatonicDegree ) {
                case I:
                    f = DiatonicFunction.I;
                    break;
                case II:
                    f = DiatonicFunction.II;
                    break;
                case III:
                    f = DiatonicFunction.III;
                    break;
                case IV:
                    f = DiatonicFunction.IV;
                    break;
                case V:
                    f = DiatonicFunction.V;
                    break;
                case VI:
                    f = DiatonicFunction.VI;
                    break;
                case VII:
                    f = DiatonicFunction.VII;
            }
            ChromaticChord chromaticChord = ChromaticChord.from(tonality, f);
            ret.add(chromaticChord);
        }

        return ret;
    }

    public static List<ChromaticChord> getSeventhChordsFrom(Tonality tonality) {
        NoDiatonicScaleException.check( tonality.getScale() );
        List<ChromaticChord> ret = new ArrayList<>();
        for (DiatonicDegree diatonicDegree : DiatonicDegree.values()) {
            DiatonicFunction f = null;
            switch ( diatonicDegree ) {
                case I:
                    f = DiatonicFunction.I7;
                    break;
                case II:
                    f = DiatonicFunction.II7;
                    break;
                case III:
                    f = DiatonicFunction.III7;
                    break;
                case IV:
                    f = DiatonicFunction.IV7;
                    break;
                case V:
                    f = DiatonicFunction.V7;
                    break;
                case VI:
                    f = DiatonicFunction.VI7;
                    break;
                case VII:
                    f = DiatonicFunction.VII7;
            }
            ChromaticChord chromaticChord = ChromaticChord.from(tonality, f);
            ret.add(chromaticChord);
        }

        return ret;
    }
}
