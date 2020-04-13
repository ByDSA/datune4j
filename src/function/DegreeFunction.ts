import { DiatonicAltChord } from 'chords/diatonicalt/DiatonicAltChord';
import { DiatonicAltChordPattern } from 'chords/diatonicalt/DiatonicAltChordPattern';
import { DiatonicAlt } from 'degrees/DiatonicAlt';
import { Tonality } from 'tonality/Tonality';
import { HarmonicFunction } from './HarmonicFunction';

export class DegreeFunction extends HarmonicFunction {
    public static I5: DegreeFunction;
    public static bII5: DegreeFunction;
    public static II5: DegreeFunction;
    public static bIII5: DegreeFunction;
    public static III5: DegreeFunction;
    public static IV5: DegreeFunction;
    public static bV5: DegreeFunction;
    public static V5: DegreeFunction;
    public static bVI5: DegreeFunction;
    public static VI5: DegreeFunction;
    public static bVII5: DegreeFunction;
    public static VII5: DegreeFunction;

    public static I: DegreeFunction;
    public static bII: DegreeFunction;
    public static N6: DegreeFunction;
    public static II: DegreeFunction;
    public static bIII: DegreeFunction;
    public static III: DegreeFunction;
    public static IV: DegreeFunction;
    public static bV: DegreeFunction;
    public static V: DegreeFunction;
    public static bVI: DegreeFunction;
    public static VI: DegreeFunction;
    public static bVII: DegreeFunction;
    public static VII: DegreeFunction;

    public static ISUS4: DegreeFunction;
    public static bIISUS4: DegreeFunction;
    public static IISUS4: DegreeFunction;
    public static bIIISUS4: DegreeFunction;
    public static IIISUS4: DegreeFunction;
    public static IVSUS4: DegreeFunction;
    public static bVSUS4: DegreeFunction;
    public static VSUS4: DegreeFunction;
    public static bVISUS4: DegreeFunction;
    public static VISUS4: DegreeFunction;
    public static bVIISUS4: DegreeFunction;
    public static VIISUS4: DegreeFunction;

    public static i: DegreeFunction;
    public static bii: DegreeFunction;
    public static ii: DegreeFunction;
    public static biii: DegreeFunction;
    public static iii: DegreeFunction;
    public static iv: DegreeFunction;
    public static bv: DegreeFunction;
    public static v: DegreeFunction;
    public static bvi: DegreeFunction;
    public static vi: DegreeFunction;
    public static bvii: DegreeFunction;
    public static vii: DegreeFunction;

    public static I0: DegreeFunction;
    public static bII0: DegreeFunction;
    public static II0: DegreeFunction;
    public static bIII0: DegreeFunction;
    public static III0: DegreeFunction;
    public static IV0: DegreeFunction;
    public static bV0: DegreeFunction;
    public static V0: DegreeFunction;
    public static bVI0: DegreeFunction;
    public static VI0: DegreeFunction;
    public static bVII0: DegreeFunction;
    public static VII0: DegreeFunction;


    public static Iaug: DegreeFunction;
    public static bIIaug: DegreeFunction;
    public static IIaug: DegreeFunction;
    public static bIIIaug: DegreeFunction;
    public static IIIaug: DegreeFunction;
    public static IVaug: DegreeFunction;
    public static bVaug: DegreeFunction;
    public static Vaug: DegreeFunction;
    public static bVIaug: DegreeFunction;
    public static VIaug: DegreeFunction;
    public static bVIIaug: DegreeFunction;
    public static VIIaug: DegreeFunction;

    /* Seventh */

    public static I7: DegreeFunction;
    public static bII7: DegreeFunction;
    public static II7: DegreeFunction;
    public static bIII7: DegreeFunction;
    public static III7: DegreeFunction;
    public static IV7: DegreeFunction;
    public static bV7: DegreeFunction;
    public static V7: DegreeFunction;
    public static bVI7: DegreeFunction;
    public static VI7: DegreeFunction;
    public static bVII7: DegreeFunction;
    public static VII7: DegreeFunction;

    public static I6: DegreeFunction;
    public static bII6: DegreeFunction;
    public static II6: DegreeFunction;
    public static bIII6: DegreeFunction;
    public static III6: DegreeFunction;
    public static IV6: DegreeFunction;
    public static bV6: DegreeFunction;
    public static V6: DegreeFunction;
    public static bVI6: DegreeFunction;
    public static VI6: DegreeFunction;
    public static bVII6: DegreeFunction;
    public static VII6: DegreeFunction;

    public static Im6: DegreeFunction;
    public static bIIm6: DegreeFunction;
    public static IIm6: DegreeFunction;
    public static bIIIm6: DegreeFunction;
    public static IIIm6: DegreeFunction;
    public static IVm6: DegreeFunction;
    public static bVm6: DegreeFunction;
    public static Vm6: DegreeFunction;
    public static bVIm6: DegreeFunction;
    public static VIm6: DegreeFunction;
    public static bVIIm6: DegreeFunction;
    public static VIIm6: DegreeFunction;

    public static IMaj7: DegreeFunction;
    public static bIIMaj7: DegreeFunction;
    public static IIMaj7: DegreeFunction;
    public static bIIIMaj7: DegreeFunction;
    public static IIIMaj7: DegreeFunction;
    public static IVMaj7: DegreeFunction;
    public static bVMaj7: DegreeFunction;
    public static VMaj7: DegreeFunction;
    public static bVIMaj7: DegreeFunction;
    public static VIMaj7: DegreeFunction;
    public static bVIIMaj7: DegreeFunction;
    public static VIIMaj7: DegreeFunction;

    public static i7: DegreeFunction;
    public static bii7: DegreeFunction;
    public static ii7: DegreeFunction;
    public static biii7: DegreeFunction;
    public static iii7: DegreeFunction;
    public static iv7: DegreeFunction;
    public static bv7: DegreeFunction;
    public static v7: DegreeFunction;
    public static bvi7: DegreeFunction;
    public static vi7: DegreeFunction;
    public static bvii7: DegreeFunction;
    public static vii7: DegreeFunction;

    public static i7b5: DegreeFunction;
    public static bii7b5: DegreeFunction;
    public static ii7b5: DegreeFunction;
    public static biii7b5: DegreeFunction;
    public static iii7b5: DegreeFunction;
    public static iv7b5: DegreeFunction;
    public static bv7b5: DegreeFunction;
    public static v7b5: DegreeFunction;
    public static bvi7b5: DegreeFunction;
    public static vi7b5: DegreeFunction;
    public static bvii7b5: DegreeFunction;
    public static vii7b5: DegreeFunction;


    public static TRIAD_FUNCTIONS: DegreeFunction[];

    public static SEVENTH_FUNCTIONS: DegreeFunction[];

    public static POWER_CHORD_FUNCTIONS: DegreeFunction[];

    public static SUS4_FUNCTIONS: DegreeFunction[];

    /********* END CONSTANTS ***********/

    protected constructor(private _chromaticDegree: ChromaticDegree, private _diatonicAltChordPattern: DiatonicAltChordPattern) {
        super();
    }

    public static from(chromaticDegree: ChromaticDegree, chromaticChordPattern: DiatonicAltChordPattern): DegreeFunction {
        return new DegreeFunction(chromaticDegree, chromaticChordPattern);
    }

    public get chromaticDegree(): ChromaticDegree {
        return this._chromaticDegree;
    }

    public get diatonicAltChordPattern(): DiatonicAltChordPattern {
        return this._diatonicAltChordPattern;
    }

    public calculateChord(tonality: Tonality): DiatonicAltChordPattern {
        let noteBase = DegreeFunction.getNoteBaseFromChromaticFunctionAndTonality(tonality, this);

        return DiatonicAltChord.fromRootPattern(noteBase, this._diatonicAltChordPattern);
    }

    private static getNoteBaseFromChromaticFunctionAndTonality(tonality: Tonality, chromaticDegreeFunction: DegreeFunction): DiatonicAlt {
        return tonality.root.getShift(chromaticDegreeFunction.chromaticDegree.ordinal());
    }

    /* Object */

    public toString(): string {
        return this._chromaticDegree + " " + this._diatonicAltChordPattern;
    }

    public hashCode(): string {
        return this._chromaticDegree.hashCode() + "|" + this._diatonicAltChordPattern.hashCode();
    }

    private static initialize() {
        DegreeFunction.I5 = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.bII5 = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.II5 = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.bIII5 = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.III5 = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.IV5 = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.bV5 = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.V5 = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.bVI5 = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.VI5 = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.bVII5 = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.POWER_CHORD);
        DegreeFunction.VII5 = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.POWER_CHORD);

        DegreeFunction.I = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.bII = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.N6 = bII;
        DegreeFunction.II = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.bIII = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.III = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.IV = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.bV = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.V = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.bVI = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.VI = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.bVII = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.TRIAD_MAJOR);
        DegreeFunction.VII = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.TRIAD_MAJOR);

        DegreeFunction.ISUS4 = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SUS4);
        DegreeFunction.bIISUS4 = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SUS4);
        DegreeFunction.IISUS4 = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SUS4);
        DegreeFunction.bIIISUS4 = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SUS4);
        DegreeFunction.IIISUS4 = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SUS4);
        DegreeFunction.IVSUS4 = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SUS4);
        DegreeFunction.bVSUS4 = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SUS4);
        DegreeFunction.VSUS4 = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SUS4);
        DegreeFunction.bVISUS4 = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SUS4);
        DegreeFunction.VISUS4 = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SUS4);
        DegreeFunction.bVIISUS4 = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SUS4);
        DegreeFunction.VIISUS4 = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SUS4);

        DegreeFunction.i = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.bii = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.ii = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.biii = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.iii = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.iv = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.bv = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.v = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.bvi = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.vi = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.bvii = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.TRIAD_MINOR);
        DegreeFunction.vii = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.TRIAD_MINOR);

        DegreeFunction.I0 = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.bII0 = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.II0 = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.bIII0 = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.III0 = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.IV0 = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.bV0 = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.V0 = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.bVI0 = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.VI0 = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.bVII0 = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.VII0 = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.TRIAD_DIMINISHED);


        DegreeFunction.Iaug = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.bIIaug = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.IIaug = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.bIIIaug = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.IIIaug = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.IVaug = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.bVaug = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.Vaug = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.bVIaug = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.VIaug = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.bVIIaug = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.VIIaug = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.TRIAD_AUGMENTED);

        /* Seventh */

        DegreeFunction.I7 = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SEVENTH);
        DegreeFunction.bII7 = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SEVENTH);
        DegreeFunction.II7 = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SEVENTH);
        DegreeFunction.bIII7 = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SEVENTH);
        DegreeFunction.III7 = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SEVENTH);
        DegreeFunction.IV7 = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SEVENTH);
        DegreeFunction.bV7 = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SEVENTH);
        DegreeFunction.V7 = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SEVENTH);
        DegreeFunction.bVI7 = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SEVENTH);
        DegreeFunction.VI7 = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SEVENTH);
        DegreeFunction.bVII7 = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SEVENTH);
        DegreeFunction.VII7 = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SEVENTH);

        DegreeFunction.I6 = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SIXTH);
        DegreeFunction.bII6 = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SIXTH);
        DegreeFunction.II6 = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SIXTH);
        DegreeFunction.bIII6 = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SIXTH);
        DegreeFunction.III6 = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SIXTH);
        DegreeFunction.IV6 = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SIXTH);
        DegreeFunction.bV6 = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SIXTH);
        DegreeFunction.V6 = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SIXTH);
        DegreeFunction.bVI6 = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SIXTH);
        DegreeFunction.VI6 = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SIXTH);
        DegreeFunction.bVII6 = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SIXTH);
        DegreeFunction.VII6 = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SIXTH);

        DegreeFunction.Im6 = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.bIIm6 = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.IIm6 = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.bIIIm6 = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.IIIm6 = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.IVm6 = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.bVm6 = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.Vm6 = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.bVIm6 = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.VIm6 = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.bVIIm6 = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SIXTH_MINOR);
        DegreeFunction.VIIm6 = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SIXTH_MINOR);

        DegreeFunction.IMaj7 = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.bIIMaj7 = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.IIMaj7 = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.bIIIMaj7 = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.IIIMaj7 = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.IVMaj7 = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.bVMaj7 = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.VMaj7 = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.bVIMaj7 = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.VIMaj7 = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.bVIIMaj7 = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SEVENTH_MAJ7);
        DegreeFunction.VIIMaj7 = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SEVENTH_MAJ7);

        DegreeFunction.i7 = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.bii7 = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.ii7 = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.biii7 = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.iii7 = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.iv7 = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.bv7 = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.v7 = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.bvi7 = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.vi7 = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.bvii7 = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SEVENTH_MINOR);
        DegreeFunction.vii7 = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SEVENTH_MINOR);

        DegreeFunction.i7b5 = new DegreeFunction(ChromaticDegree.I, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.bii7b5 = new DegreeFunction(ChromaticDegree.bII, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.ii7b5 = new DegreeFunction(ChromaticDegree.II, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.biii7b5 = new DegreeFunction(ChromaticDegree.bIII, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.iii7b5 = new DegreeFunction(ChromaticDegree.III, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.iv7b5 = new DegreeFunction(ChromaticDegree.IV, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.bv7b5 = new DegreeFunction(ChromaticDegree.bV, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.v7b5 = new DegreeFunction(ChromaticDegree.V, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.bvi7b5 = new DegreeFunction(ChromaticDegree.bVI, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.vi7b5 = new DegreeFunction(ChromaticDegree.VI, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.bvii7b5 = new DegreeFunction(ChromaticDegree.bVII, ChromaticChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.vii7b5 = new DegreeFunction(ChromaticDegree.VII, ChromaticChordPattern.SEVENTH_MINOR_b5);
    }
}
