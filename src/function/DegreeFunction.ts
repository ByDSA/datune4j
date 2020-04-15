import { DiatonicAltChord } from '../chords/diatonicalt/DiatonicAltChord';
import { DiatonicAltChordPattern } from '../chords/diatonicalt/DiatonicAltChordPattern';
import { Chromatic } from '../degrees/Chromatic';
import { Diatonic } from '../degrees/Diatonic';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { DiatonicAltDegree } from '../degrees/scale/DiatonicAltDegree';
import { DiatonicDegree } from '../degrees/scale/DiatonicDegree';
import { Tonality } from '../tonality/Tonality';
import { ImmutablesCache } from '../common/ImmutablesCache';
import { HarmonicFunction } from './HarmonicFunction';

type HashingObjectType = { degree: DiatonicAltDegree, pattern: DiatonicAltChordPattern };
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

    private static hashCodeFunction(degree: DiatonicAltDegree, pattern: DiatonicAltChordPattern): string {
        return degree.hashCode() + "|" + pattern.hashCode();
    }

    private static immutablesCache = new ImmutablesCache<DegreeFunction, HashingObjectType>(
        function (hashingObject: HashingObjectType): string {
            return DegreeFunction.hashCodeFunction(hashingObject.degree, hashingObject.pattern);
        },
        function (degreeFunction: DegreeFunction): HashingObjectType {
            return { degree: degreeFunction.diatonicAltDegree, pattern: degreeFunction.diatonicAltChordPattern };
        },
        function (hashingObject: HashingObjectType): DegreeFunction {
            return new DegreeFunction(hashingObject.degree, hashingObject.pattern);
        }
    );

    protected constructor(private _degree: DiatonicAltDegree, private _pattern: DiatonicAltChordPattern) {
        super();
    }

    public static from(degree: DiatonicAltDegree, pattern: DiatonicAltChordPattern): DegreeFunction {
        return this.immutablesCache.getOrCreate({ degree: degree, pattern: pattern });
    }

    public get diatonicAltDegree(): DiatonicAltDegree {
        return this._degree;
    }

    public get diatonicAltChordPattern(): DiatonicAltChordPattern {
        return this._pattern;
    }

    public calculateChord(tonality: Tonality): DiatonicAltChord {
        let noteBase: DiatonicAlt = DegreeFunction.getNoteBaseFromChromaticFunctionAndTonality(tonality, this);

        return DiatonicAltChord.fromRootPattern(noteBase, this._pattern);
    }

    private static getNoteBaseFromChromaticFunctionAndTonality(tonality: Tonality, degreeFunction: DegreeFunction): DiatonicAlt {
        return tonality.root.getAdd(degreeFunction.diatonicAltDegree.intervalDiatonicAlt);
    }

    private _degrees: DiatonicAltDegree[];

    public get degrees(): DiatonicAltDegree[] {
        if (!this._degrees) {
            this._degrees = [];
            for (let value of this.diatonicAltChordPattern) {
                let diatonicDegreeInt = this.diatonicAltDegree.diatonicDegree.intValue + value.diatonicIntValue;
                let diatonicDegree = DiatonicDegree.fromInt(diatonicDegreeInt);
                let alts = Diatonic.fromInt(diatonicDegree.intValue).chromatic.intValue - (this.diatonicAltDegree.semis + value.semis);
                alts %= Chromatic.NUMBER;
                let degree = DiatonicAltDegree.from(diatonicDegree, alts);
                this._degrees.push(degree);
            }
        }

        return this._degrees;
    }

    /* Object */

    public toString(): string {
        return this._degree + " " + this._pattern;
    }

    public hashCode(): string {
        return DegreeFunction.hashCodeFunction(this._degree, this._pattern);
    }

    private static initialize() {
        DegreeFunction.I5 = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.bII5 = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.II5 = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.bIII5 = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.III5 = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.IV5 = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.bV5 = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.V5 = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.bVI5 = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.VI5 = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.bVII5 = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.POWER_CHORD);
        DegreeFunction.VII5 = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.POWER_CHORD);

        DegreeFunction.I = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.bII = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.N6 = DegreeFunction.bII;
        DegreeFunction.II = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.bIII = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.III = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.IV = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.bV = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.V = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.bVI = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.VI = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.bVII = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.TRIAD_MAJOR);
        DegreeFunction.VII = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.TRIAD_MAJOR);

        DegreeFunction.ISUS4 = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.bIISUS4 = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.IISUS4 = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.bIIISUS4 = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.IIISUS4 = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.IVSUS4 = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.bVSUS4 = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.VSUS4 = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.bVISUS4 = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.VISUS4 = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.bVIISUS4 = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.TRIAD_SUS4);
        DegreeFunction.VIISUS4 = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.TRIAD_SUS4);

        DegreeFunction.i = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.bii = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.ii = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.biii = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.iii = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.iv = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.bv = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.v = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.bvi = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.vi = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.bvii = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.TRIAD_MINOR);
        DegreeFunction.vii = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.TRIAD_MINOR);

        DegreeFunction.I0 = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.bII0 = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.II0 = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.bIII0 = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.III0 = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.IV0 = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.bV0 = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.V0 = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.bVI0 = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.VI0 = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.bVII0 = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.TRIAD_DIMINISHED);
        DegreeFunction.VII0 = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.TRIAD_DIMINISHED);


        DegreeFunction.Iaug = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.bIIaug = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.IIaug = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.bIIIaug = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.IIIaug = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.IVaug = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.bVaug = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.Vaug = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.bVIaug = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.VIaug = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.bVIIaug = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.TRIAD_AUGMENTED);
        DegreeFunction.VIIaug = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.TRIAD_AUGMENTED);

        /* Seventh */

        DegreeFunction.I7 = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.bII7 = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.II7 = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.bIII7 = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.III7 = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.IV7 = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.bV7 = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.V7 = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.bVI7 = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.VI7 = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.bVII7 = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.SEVENTH);
        DegreeFunction.VII7 = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.SEVENTH);

        DegreeFunction.I6 = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.bII6 = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.II6 = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.bIII6 = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.III6 = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.IV6 = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.bV6 = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.V6 = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.bVI6 = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.VI6 = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.bVII6 = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.SIXTH);
        DegreeFunction.VII6 = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.SIXTH);

        DegreeFunction.Im6 = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.bIIm6 = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.IIm6 = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.bIIIm6 = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.IIIm6 = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.IVm6 = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.bVm6 = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.Vm6 = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.bVIm6 = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.VIm6 = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.bVIIm6 = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.SIXTH_MINOR);
        DegreeFunction.VIIm6 = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.SIXTH_MINOR);

        DegreeFunction.IMaj7 = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.bIIMaj7 = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.IIMaj7 = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.bIIIMaj7 = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.IIIMaj7 = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.IVMaj7 = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.bVMaj7 = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.VMaj7 = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.bVIMaj7 = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.VIMaj7 = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.bVIIMaj7 = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.SEVENTH_MAJ7);
        DegreeFunction.VIIMaj7 = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.SEVENTH_MAJ7);

        DegreeFunction.i7 = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.bii7 = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.ii7 = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.biii7 = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.iii7 = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.iv7 = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.bv7 = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.v7 = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.bvi7 = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.vi7 = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.bvii7 = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.SEVENTH_MINOR);
        DegreeFunction.vii7 = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.SEVENTH_MINOR);

        DegreeFunction.i7b5 = DegreeFunction.from(DiatonicAltDegree.I, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.bii7b5 = DegreeFunction.from(DiatonicAltDegree.bII, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.ii7b5 = DegreeFunction.from(DiatonicAltDegree.II, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.biii7b5 = DegreeFunction.from(DiatonicAltDegree.bIII, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.iii7b5 = DegreeFunction.from(DiatonicAltDegree.III, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.iv7b5 = DegreeFunction.from(DiatonicAltDegree.IV, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.bv7b5 = DegreeFunction.from(DiatonicAltDegree.bV, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.v7b5 = DegreeFunction.from(DiatonicAltDegree.V, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.bvi7b5 = DegreeFunction.from(DiatonicAltDegree.bVI, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.vi7b5 = DegreeFunction.from(DiatonicAltDegree.VI, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.bvii7b5 = DegreeFunction.from(DiatonicAltDegree.bVII, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
        DegreeFunction.vii7b5 = DegreeFunction.from(DiatonicAltDegree.VII, DiatonicAltChordPattern.SEVENTH_MINOR_b5);
    }
}
