package es.danisales.datune.function;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import es.danisales.datune.chords.chromatic.ChromaticChord;
import es.danisales.datune.chords.chromatic.ChromaticChordPattern;
import es.danisales.datune.degrees.octave.Chromatic;
import es.danisales.datune.degrees.scale.ChromaticDegree;
import es.danisales.datune.tonality.ScaleRelativeDegreeException;
import es.danisales.datune.tonality.Tonality;
import es.danisales.utils.NeverHappensException;
import es.danisales.utils.building.BuildingException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

@SuppressWarnings("WeakerAccess")
public final class ChromaticDegreeFunction implements ChromaticFunction {
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

    public static final ChromaticDegreeFunction I7 = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction bII7 = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction II7 = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction bIII7 = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction III7 = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction IV7 = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction bV7 = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction V7 = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction bVI7 = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction VI7 = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction bVII7 = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SEVENTH);
    public static final ChromaticDegreeFunction VII7 = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SEVENTH);

    /* Compound */

    public static final ChromaticDegreeFunction V_II = new ChromaticDegreeFunction("V/II", II, V);
    public static final ChromaticDegreeFunction V_III = new ChromaticDegreeFunction("V/III", III, V);
    public static final ChromaticDegreeFunction V_IV = new ChromaticDegreeFunction("V/IV", IV, V);
    public static final ChromaticDegreeFunction V_V = new ChromaticDegreeFunction("V/V", V, V);
    public static final ChromaticDegreeFunction V_VI = new ChromaticDegreeFunction("V/VI", VI, V);

    public static final ChromaticDegreeFunction V7_II = new ChromaticDegreeFunction("V7/II", II, V7);
    public static final ChromaticDegreeFunction V7_III = new ChromaticDegreeFunction("V7/III", III, V7);
    public static final ChromaticDegreeFunction V7_IV = new ChromaticDegreeFunction("V7/IV", IV, V7);
    public static final ChromaticDegreeFunction V7_V = new ChromaticDegreeFunction("V/7V", V, V7);
    public static final ChromaticDegreeFunction V7_VI = new ChromaticDegreeFunction("V7/VI", VI, V7);

    public static final ChromaticDegreeFunction SUBV7 = new ChromaticDegreeFunction("SUBV7/I", I, bII7);
    public static final ChromaticDegreeFunction SUBV7_II = new ChromaticDegreeFunction("SUBV7/II", II, bII7);
    public static final ChromaticDegreeFunction SUBV7_III = new ChromaticDegreeFunction("SUBV7/III", III, bII7);
    public static final ChromaticDegreeFunction SUBV7_IV = new ChromaticDegreeFunction("SUBV7/IV", IV, bII7);
    public static final ChromaticDegreeFunction SUBV7_V = new ChromaticDegreeFunction("SUBV7/V", V, bII7);
    public static final ChromaticDegreeFunction SUBV7_VI = new ChromaticDegreeFunction("SUBV7/VI", VI, bII7);

    public static final List<ChromaticDegreeFunction> SECONDARY_DOMINANT_FUNCTIONS = new ImmutableList.Builder<ChromaticDegreeFunction>()
            .add(V_II, V_III, V_IV, V_V, V_VI)
            .add(V7_II, V7_III, V7_IV, V7_V, V7_VI)
            .add(SUBV7_II, SUBV7_III, SUBV7_IV, SUBV7_V, SUBV7_VI)

            .build();


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

    public static final List<ChromaticDegreeFunction> POWER_CHORD_FUNCTIONS = new ImmutableList.Builder<ChromaticDegreeFunction>()
            .add(I5)
            .add(bII5)
            .add(II5)
            .add(bIII5)
            .add(III5)
            .add(IV5)
            .add(bV5)
            .add(V5)
            .add(bVI5)
            .add(VI5)
            .add(bVII5)
            .add(VII5)
            .build();

    public static final List<ChromaticDegreeFunction> SUS4_FUNCTIONS = new ImmutableList.Builder<ChromaticDegreeFunction>()
            .add(ISUS4)
            .add(bIISUS4)
            .add(IISUS4)
            .add(bIIISUS4)
            .add(IIISUS4)
            .add(IVSUS4)
            .add(bVSUS4)
            .add(VSUS4)
            .add(bVISUS4)
            .add(VISUS4)
            .add(bVIISUS4)
            .add(VIISUS4)
            .build();

    /********* END CONSTANTS ***********/

    private final ChromaticDegree chromaticDegree;
    private final ChromaticChordPattern chromaticChordPattern;
    private final String str;

    private ChromaticDegreeFunction(@NonNull ChromaticDegree chromaticDegree, @NonNull ChromaticChordPattern chromaticChordPattern) {
        this.chromaticDegree = chromaticDegree;
        this.chromaticChordPattern = chromaticChordPattern;

        StringBuilder stringBuilder = new StringBuilder();
        if (chromaticChordPattern.equals(ChromaticChordPattern.TRIAD_MINOR)) {
            stringBuilder.append(chromaticDegree.toString().toLowerCase());
        } else
            stringBuilder.append(chromaticDegree.toString());

        String s = chromaticChordPattern.symbol();
        if (s != null)
            stringBuilder.append(s);

        this.str = stringBuilder.toString();
    }

    private ChromaticDegreeFunction(String str, @NonNull ChromaticDegree chromaticDegree, @NonNull ChromaticChordPattern chromaticChordPattern) {
        this.chromaticDegree = chromaticDegree;
        this.chromaticChordPattern = chromaticChordPattern;
        this.str = str;
    }

    private ChromaticDegreeFunction(String str, @NonNull ChromaticDegreeFunction... array) {
        ChromaticDegree chromaticDegree = ChromaticDegree.I;
        for (ChromaticDegreeFunction chromaticDegreeFunction : array) {
            chromaticDegree = chromaticDegree.getShifted(chromaticDegreeFunction.getChromaticDegree().ordinal());
        }

        this.chromaticDegree = chromaticDegree;
        this.chromaticChordPattern = array[array.length-1].chromaticChordPattern;
        this.str = str;
    }

    public static ChromaticDegreeFunction from(@NonNull ChromaticDegreeFunction... array) {
        return new ChromaticDegreeFunction("", array);
    }

    private static final Map<Integer, ChromaticDegreeFunction> immutableMap = Maps.newHashMap(ImmutableMap.<Integer, ChromaticDegreeFunction>builder()
            .put(I.hashCode(), I)
            .put(bII.hashCode(), bII)
            .put(II.hashCode(), II)
            .put(bIII.hashCode(), bIII)
            .put(III.hashCode(), III)
            .put(IV.hashCode(), IV)
            .put(bV.hashCode(), bV)
            .put(V.hashCode(), V)
            .put(bVI.hashCode(), bVI)
            .put(VI.hashCode(), VI)
            .put(bVII.hashCode(), bVII)
            .put(VII.hashCode(), VII)

            .put(i.hashCode(), i)
            .put(bii.hashCode(), bii)
            .put(ii.hashCode(), ii)
            .put(biii.hashCode(), biii)
            .put(iii.hashCode(), iii)
            .put(iv.hashCode(), iv)
            .put(bv.hashCode(), bv)
            .put(v.hashCode(), v)
            .put(bvi.hashCode(), bvi)
            .put(vi.hashCode(), vi)
            .put(bvii.hashCode(), bvii)
            .put(vii.hashCode(), vii)

            .put(I0.hashCode(), I0)
            .put(bII0.hashCode(), bII0)
            .put(II0.hashCode(), II0)
            .put(bIII0.hashCode(), bIII0)
            .put(III0.hashCode(), III0)
            .put(IV0.hashCode(), IV0)
            .put(bV0.hashCode(), bV0)
            .put(V0.hashCode(), V0)
            .put(bVI0.hashCode(), bVI0)
            .put(VI0.hashCode(), VI0)
            .put(bVII0.hashCode(), bVII0)
            .put(VII0.hashCode(), VII0)

            .put(Iaug.hashCode(), Iaug)
            .put(bIIaug.hashCode(), bIIaug)
            .put(IIaug.hashCode(), IIaug)
            .put(bIIIaug.hashCode(), bIIIaug)
            .put(IIIaug.hashCode(), IIIaug)
            .put(IVaug.hashCode(), IVaug)
            .put(bVaug.hashCode(), bVaug)
            .put(Vaug.hashCode(), Vaug)
            .put(bVIaug.hashCode(), bVIaug)
            .put(VIaug.hashCode(), VIaug)
            .put(bVIIaug.hashCode(), bVIIaug)
            .put(VIIaug.hashCode(), VIIaug)

            .build()
    );

    public static @NonNull ChromaticDegreeFunction from(ChromaticDegree chromaticDegree, ChromaticChordPattern chromaticChordPattern) {
        ChromaticDegreeFunction immutable = immutableMap.get(chromaticDegree.hashCode() + chromaticChordPattern.hashCode());
        if (immutable != null)
            return immutable;
        return new ChromaticDegreeFunction(chromaticDegree, chromaticChordPattern);
    }

    private static final List<ChromaticDegreeFunction> immutableValues = new ImmutableList.Builder<ChromaticDegreeFunction>()
            .addAll(TRIAD_FUNCTIONS)
            .addAll(POWER_CHORD_FUNCTIONS)
            .addAll(SUS4_FUNCTIONS)
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

    @Override
    public ChromaticDegreeFunction getShifted(int i) {
        ChromaticDegree chromaticDegree = getChromaticDegree().getShifted(i);

        return ChromaticDegreeFunction.from(chromaticDegree, getChromaticChordPattern());
    }

    @Override
    @NonNull
    public ChromaticChord getChromaticChordFromTonality(Tonality<Chromatic> tonality) throws ScaleRelativeDegreeException {
        Objects.requireNonNull(tonality);

        ChromaticChordPattern chromaticChordPattern = getChromaticChordPattern();
        Objects.requireNonNull(chromaticChordPattern, toString());
        Chromatic noteBase = TonalityGetChromaticFunction.getNoteBaseFromChromaticFunctionAndTonality(tonality, this);

        ChromaticChord ret;
        try {
            ret = ChromaticChord.builder()
                    .chromaticBase(noteBase)
                    .chromaticChordPattern(chromaticChordPattern)
                    .build();
        } catch (BuildingException e) {
            throw NeverHappensException.make("");
        }

        return ret;
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

            .put(ISUS4, "ISUS4")
            .put(bIISUS4, "bIISUS4")
            .put(IISUS4, "IISUS4")
            .put(bIIISUS4, "bIIISUS4")
            .put(IVSUS4, "IVSUS4")
            .put(bVSUS4, "bVSUS4")
            .put(VSUS4, "VSUS4")
            .put(bVISUS4, "bVISUS4")
            .put(VISUS4, "VISUS4")
            .put(bVIISUS4, "bVIISUS4")
            .put(VIISUS4, "VIISUS4")

            .put(V_II, "V/II")
            .put(V_III, "V/III")
            .put(V_IV, "V/IV")
            .put(V_V, "V/V")
            .put(V_VI, "V/VI")

            .put(V7_II, "V7/II")
            .put(V7_III, "V7/III")
            .put(V7_IV, "V7/IV")
            .put(V7_V, "V7/V")
            .put(V7_VI, "V7/VI")

            .put(SUBV7_II, "SUBV7/II")
            .put(SUBV7_III, "SUBV7/III")
            .put(SUBV7_IV, "SUBV7/IV")
            .put(SUBV7_V, "SUBV7/V")
            .put(SUBV7_VI, "SUBV7/VI")

            .build();

    @Override
    public String toString() {
        checkNotNull(defaultStringValues);

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

        return chromaticDegreeFunction.chromaticChordPattern.equals(chromaticChordPattern) && chromaticDegree.equals(chromaticDegreeFunction.chromaticDegree)
                && chromaticDegreeFunction.str.equals(str);
    }

    @Override
    public int hashCode() {
        return chromaticDegree.hashCode() + chromaticChordPattern.hashCode();
    }
}
