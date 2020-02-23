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
import es.danisales.datune.tonality.TonalityModern;
import es.danisales.utils.NeverHappensException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

@SuppressWarnings("WeakerAccess")
public class ChromaticDegreeFunction implements HarmonicFunction {
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

    /* Seventh */

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

    public static final ChromaticDegreeFunction I6 = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction bII6 = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction II6 = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction bIII6 = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction III6 = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction IV6 = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction bV6 = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction V6 = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction bVI6 = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction VI6 = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction bVII6 = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SIXTH);
    public static final ChromaticDegreeFunction VII6 = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SIXTH);

    public static final ChromaticDegreeFunction Im6 = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction bIIm6 = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction IIm6 = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction bIIIm6 = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction IIIm6 = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction IVm6 = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction bVm6 = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction Vm6 = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction bVIm6 = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction VIm6 = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction bVIIm6 = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SIXTH_MINOR);
    public static final ChromaticDegreeFunction VIIm6 = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SIXTH_MINOR);

    public static final ChromaticDegreeFunction IMaj7 = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction bIIMaj7 = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction IIMaj7 = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction bIIIMaj7 = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction IIIMaj7 = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction IVMaj7 = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction bVMaj7 = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction VMaj7 = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction bVIMaj7 = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction VIMaj7 = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction bVIIMaj7 = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SEVENTH_MAJ7);
    public static final ChromaticDegreeFunction VIIMaj7 = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SEVENTH_MAJ7);

    public static final ChromaticDegreeFunction i7 = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction bii7 = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction ii7 = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction biii7 = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction iii7 = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction iv7 = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction bv7 = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction v7 = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction bvi7 = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction vi7 = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction bvii7 = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SEVENTH_MINOR);
    public static final ChromaticDegreeFunction vii7 = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SEVENTH_MINOR);

    public static final ChromaticDegreeFunction i7b5 = new ChromaticDegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction bii7b5 = new ChromaticDegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction ii7b5 = new ChromaticDegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction biii7b5 = new ChromaticDegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction iii7b5 = new ChromaticDegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction iv7b5 = new ChromaticDegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction bv7b5 = new ChromaticDegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction v7b5 = new ChromaticDegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction bvi7b5 = new ChromaticDegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction vi7b5 = new ChromaticDegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction bvii7b5 = new ChromaticDegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SEVENTH_MINOR_b5);
    public static final ChromaticDegreeFunction vii7b5 = new ChromaticDegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SEVENTH_MINOR_b5);


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

    public static final List<ChromaticDegreeFunction> SEVENTH_FUNCTIONS = new ImmutableList.Builder<ChromaticDegreeFunction>()
            .add(IMaj7)
            .add(bIIMaj7)
            .add(IIMaj7)
            .add(bIIIMaj7)
            .add(IIIMaj7)
            .add(IVMaj7)
            .add(bVMaj7)
            .add(VMaj7)
            .add(bVIMaj7)
            .add(VIMaj7)
            .add(bVIIMaj7)
            .add(VIIMaj7)

            .add(I7)
            .add(bII7)
            .add(II7)
            .add(bIII7)
            .add(III7)
            .add(IV7)
            .add(bV7)
            .add(V7)
            .add(bVI7)
            .add(VI7)
            .add(bVII7)
            .add(VII7)

            .add(i7)
            .add(bii7)
            .add(ii7)
            .add(biii7)
            .add(iii7)
            .add(iv7)
            .add(bv7)
            .add(v7)
            .add(bvi7)
            .add(vi7)
            .add(bvii7)
            .add(vii7)

            .add(i7b5)
            .add(bii7b5)
            .add(ii7b5)
            .add(biii7b5)
            .add(iii7b5)
            .add(iv7b5)
            .add(bv7b5)
            .add(v7b5)
            .add(bvi7b5)
            .add(vi7b5)
            .add(bvii7b5)
            .add(vii7b5)

            .add(I6)
            .add(bII6)
            .add(II6)
            .add(bIII6)
            .add(III6)
            .add(IV6)
            .add(bV6)
            .add(V6)
            .add(bVI6)
            .add(VI6)
            .add(bVII6)
            .add(VII6)

            .add(Im6)
            .add(bIIm6)
            .add(IIm6)
            .add(bIIIm6)
            .add(IIIm6)
            .add(IVm6)
            .add(bVm6)
            .add(Vm6)
            .add(bVIm6)
            .add(VIm6)
            .add(bVIIm6)
            .add(VIIm6)

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

    protected ChromaticDegreeFunction(@NonNull ChromaticDegree chromaticDegree, @NonNull ChromaticChordPattern chromaticChordPattern) {
        this.chromaticDegree = chromaticDegree;
        this.chromaticChordPattern = chromaticChordPattern;

        StringBuilder stringBuilder = new StringBuilder();
        if (chromaticChordPattern.equals(ChromaticChordPattern.TRIAD_MINOR)) {
            stringBuilder.append(chromaticDegree.toString().toLowerCase());
        } else
            stringBuilder.append(chromaticDegree.toString());

        String s = chromaticChordPattern.getSuffix();
        if (s != null)
            stringBuilder.append(s);

        this.str = stringBuilder.toString();
    }

    protected ChromaticDegreeFunction(String str, @NonNull ChromaticDegree chromaticDegree, @NonNull ChromaticChordPattern chromaticChordPattern) {
        this.chromaticDegree = chromaticDegree;
        this.chromaticChordPattern = chromaticChordPattern;
        this.str = str;
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
            .addAll(SEVENTH_FUNCTIONS)
            .addAll(POWER_CHORD_FUNCTIONS)
            .addAll(SUS4_FUNCTIONS)
            .build();

    public static List<ChromaticDegreeFunction> immutableValues() {
        return immutableValues;
    }

    public ChromaticDegree getChromaticDegree() {
        return chromaticDegree;
    }

    public ChromaticChordPattern getChromaticChordPattern() {
        return chromaticChordPattern;
    }

    @Override
    @NonNull
    public ChromaticDegreeFunction getShifted(int i) {
        ChromaticDegree chromaticDegree = getChromaticDegree().getShifted(i);

        return ChromaticDegreeFunction.from(chromaticDegree, getChromaticChordPattern());
    }

    @Override
    @NonNull
    public ChromaticChord getChord(@NonNull TonalityModern tonality) throws ScaleRelativeDegreeException {
        Objects.requireNonNull(tonality);

        ChromaticChordPattern chromaticChordPattern = getChromaticChordPattern();
        Objects.requireNonNull(chromaticChordPattern, toString());
        Chromatic noteBase = getNoteBaseFromChromaticFunctionAndTonality(tonality, this);

        ChromaticChord ret;
        try {
            ret = ChromaticChord.builder()
                    .chromaticBase(noteBase)
                    .chromaticChordPattern(chromaticChordPattern)
                    .build();
        } catch (Exception e) {
            throw NeverHappensException.make("");
        }

        return ret;
    }

    static @NonNull Chromatic getNoteBaseFromChromaticFunctionAndTonality(Tonality<Chromatic> tonality, @NonNull ChromaticDegreeFunction chromaticDegreeFunction) throws ScaleRelativeDegreeException {
        return tonality.getRoot().getShifted(chromaticDegreeFunction.getChromaticDegree().ordinal());
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
        if ( !(o instanceof ChromaticDegreeFunction) )
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
