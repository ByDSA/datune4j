package es.danisales.datune.function;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import es.danisales.datune.chords.chromatic.ChromaticChordPattern;
import es.danisales.datune.degrees.scale.ChromaticDegree;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Map;

public final class ChromaticDegreeFunction implements HarmonicFunction {
    public static final ChromaticDegreeFunction I = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction bII = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction N6 = bII;
    public static final ChromaticDegreeFunction II = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction bIII = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction III = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction IV = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction bV = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction V = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction bVI = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction VI = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction bVII = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.TRIAD_MAJOR);
    public static final ChromaticDegreeFunction VII = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.TRIAD_MAJOR);

    public static final ChromaticDegreeFunction I5 = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction bII5 = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction II5 = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction bIII5 = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction III5 = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction IV5 = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction bV5 = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction V5 = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction bVI5 = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction VI5 = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction bVII5 = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.POWER_CHORD);
    public static final ChromaticDegreeFunction VII5 = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.POWER_CHORD);

    public static final ChromaticDegreeFunction ISUS4 = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction bIISUS4 = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction IISUS4 = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction bIIISUS4 = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction IIISUS4 = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction IVSUS4 = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction bVSUS4 = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction VSUS4 = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction bVISUS4 = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction VISUS4 = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction bVIISUS4 = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SUS4);
    public static final ChromaticDegreeFunction VIISUS4 = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SUS4);

    public static final ChromaticDegreeFunction i = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction bii = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction ii = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction biii = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction iii = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction iv = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction bv = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction v = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction bvi = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction vi = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction bvii = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.TRIAD_MINOR);
    public static final ChromaticDegreeFunction vii = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.TRIAD_MINOR);

    public static final ChromaticDegreeFunction I0 = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction bII0 = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction II0 = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction bIII0 = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction III0 = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction IV0 = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction bV0 = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction V0 = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction bVI0 = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction VI0 = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction bVII0 = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.TRIAD_DIMINISHED);
    public static final ChromaticDegreeFunction VII0 = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.TRIAD_DIMINISHED);

    public static final ChromaticDegreeFunction Iaug = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction bIIaug = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction IIaug = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction bIIIaug = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction IIIaug = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction IVaug = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction bVaug = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction Vaug = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction bVIaug = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction VIaug = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction bVIIaug = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.TRIAD_AUGMENTED);
    public static final ChromaticDegreeFunction VIIaug = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.TRIAD_AUGMENTED);

    public static final List<ChromaticDegreeFunction> TRIAD_FUNCTIONS = new ImmutableList.Builder<ChromaticDegreeFunction>()
            .add(I)
            .add(bII)
            .add(II)
            .add(bIII)
            .add(III)
            .add(IV)
            .add(bV)
            .add(V)
            .add(bVI)
            .add(VI)
            .add(bVII)
            .add(VII)

            .add(i)
            .add(bii)
            .add(ii)
            .add(biii)
            .add(iii)
            .add(iv)
            .add(bv)
            .add(v)
            .add(bvi)
            .add(vi)
            .add(bvii)
            .add(vii)

            .add(I0)
            .add(bII0)
            .add(II0)
            .add(bIII0)
            .add(III0)
            .add(IV0)
            .add(bV0)
            .add(V0)
            .add(bVI0)
            .add(VI0)
            .add(bVII0)
            .add(VII0)

            .add(Iaug)
            .add(bIIaug)
            .add(IIaug)
            .add(bIIIaug)
            .add(IIIaug)
            .add(IVaug)
            .add(bVaug)
            .add(Vaug)
            .add(bVIaug)
            .add(VIaug)
            .add(bVIIaug)
            .add(VIIaug)
            .build();

    public static final List<ChromaticDegreeFunction> POWER_CHORDS = new ImmutableList.Builder<ChromaticDegreeFunction>()
            .add(I5)
            .add(II5)
            .add(III5)
            .add(IV5)
            .add(V5)
            .add(VI5)
            .add(VII5)
            .build();

    public static final List<ChromaticDegreeFunction> SUS4 = new ImmutableList.Builder<ChromaticDegreeFunction>()
            .add(ISUS4)
            .add(IISUS4)
            .add(bIIISUS4)
            .add(IVSUS4)
            .add(VSUS4)
            .add(VISUS4)
            .add(bVIISUS4)
            .build();

    private final ChromaticDegree chromaticDegree;
    private final ChromaticChordPattern chromaticChordPattern;

    private ChromaticDegreeFunction(@NonNull ChromaticDegree chromaticDegree, @NonNull ChromaticChordPattern chromaticChordPattern) {
        this.chromaticDegree = chromaticDegree;
        this.chromaticChordPattern = chromaticChordPattern;
    }

    public static @NonNull ChromaticDegreeFunction from(ChromaticDegree chromaticDegree, ChromaticChordPattern chromaticChordPattern) {
        return new ChromaticDegreeFunction(chromaticDegree, chromaticChordPattern);
    }

    private static final List<ChromaticDegreeFunction> immutableValues = new ImmutableList.Builder<ChromaticDegreeFunction>()
            .addAll(TRIAD_FUNCTIONS)
            .addAll(POWER_CHORDS)
            .addAll(SUS4)
            .build();

    public static List<ChromaticDegreeFunction> values() {
        return immutableValues;
    }

    public ChromaticDegree getChromaticDegree() {
        return chromaticDegree;
    }

    public ChromaticChordPattern getChromaticChordPattern() {
        return chromaticChordPattern;
    }

    /* Object */

    private static final Map<ChromaticDegreeFunction, String> defaultStringValues = ImmutableMap.<ChromaticDegreeFunction, String>builder()
            .put(I, "I")
            .put(bII, "bII")
            .put(II, "II")
            .put(bIII, "bIII")
            .put(III, "III")
            .put(IV, "IV")
            .put(bV, "bV")
            .put(V, "V")
            .put(bVI, "bVI")
            .put(VI, "VI")
            .put(bVII, "bVII")
            .put(VII, "VII")

            .put(i, "i")
            .put(bii, "bii")
            .put(ii, "ii")
            .put(biii, "biii")
            .put(iii, "iii")
            .put(iv, "iv")
            .put(bv, "bv")
            .put(v, "v")
            .put(bvi, "bvi")
            .put(vi, "vi")
            .put(bvii, "bvii")
            .put(vii, "vii")

            .put(I0, "I0")
            .put(bII0, "bII0")
            .put(II0, "II0")
            .put(bIII0, "bIII0")
            .put(III0, "III0")
            .put(IV0, "IV0")
            .put(bV0, "bV0")
            .put(V0, "V0")
            .put(bVI0, "bVI0")
            .put(VI0, "VI0")
            .put(bVII0, "bVII0")
            .put(VII0, "VII0")

            .put(Iaug, "I+")
            .put(bIIaug, "bII+")
            .put(IIaug, "II+")
            .put(bIIIaug, "bIII+")
            .put(IIIaug, "III+")
            .put(IVaug, "IV+")
            .put(bVaug, "bV+")
            .put(Vaug, "V+")
            .put(bVIaug, "bVI+")
            .put(VIaug, "VI+")
            .put(bVIIaug, "bVII+")
            .put(VIIaug, "VII+")

            .build();

    @Override
    public String toString() {
        String str = defaultStringValues.get(this);
        if (str != null)
            return str;

        return chromaticDegree + " " + chromaticChordPattern;
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof  ChromaticDegreeFunction) )
            return false;

        ChromaticDegreeFunction chromaticDegreeFunction = (ChromaticDegreeFunction)o;

        return chromaticDegreeFunction.chromaticChordPattern.equals(chromaticChordPattern) && chromaticDegree.equals(chromaticDegreeFunction.chromaticDegree);
    }
}
