import { ChromaticChordPattern } from '../chords/chromatic/ChromaticChordPattern';
import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { Chromatic } from '../degrees/Chromatic';
import { Diatonic } from '../degrees/Diatonic';
import { Settings } from '../settings/Settings';
import { Scale } from '../tonality/Scale';
import { Tonality } from '../tonality/Tonality';

export class Naming {
    private constructor() {
    }

    public static chromatic(chromatic: Chromatic): string {
        switch (chromatic) {
            case Chromatic.C: return Naming.diatonic(Diatonic.C);
            case Chromatic.CC: return Naming.diatonic(Diatonic.C) + Settings.symbols.alts(1);
            case Chromatic.D: return Naming.diatonic(Diatonic.D);
            case Chromatic.DD: return Naming.diatonic(Diatonic.D) + Settings.symbols.alts(1);
            case Chromatic.E: return Naming.diatonic(Diatonic.E);
            case Chromatic.F: return Naming.diatonic(Diatonic.F);
            case Chromatic.FF: return Naming.diatonic(Diatonic.F) + Settings.symbols.alts(1);
            case Chromatic.G: return Naming.diatonic(Diatonic.G);
            case Chromatic.GG: return Naming.diatonic(Diatonic.G) + Settings.symbols.alts(1);
            case Chromatic.A: return Naming.diatonic(Diatonic.A);
            case Chromatic.AA: return Naming.diatonic(Diatonic.A) + Settings.symbols.alts(1);
            case Chromatic.B: return Naming.diatonic(Diatonic.B);
        }

        throw new Error("Can't get string from '" + chromatic + "'.");
    }

    static getChromatic(noteStr: string): Chromatic {
        noteStr = noteStr
        .replace('#', Settings.symbols.sharp)
        .replace('b', Settings.symbols.bemol);
        
        switch (noteStr) {
            case Naming.chromatic(Chromatic.C): return Chromatic.C;
            case Naming.chromatic(Chromatic.CC): return Chromatic.CC;
            case Naming.chromatic(Chromatic.D): return Chromatic.D;
            case Naming.chromatic(Chromatic.DD): return Chromatic.DD;
            case Naming.chromatic(Chromatic.E): return Chromatic.E;
            case Naming.chromatic(Chromatic.F): return Chromatic.F;
            case Naming.chromatic(Chromatic.FF): return Chromatic.FF;
            case Naming.chromatic(Chromatic.G): return Chromatic.G;
            case Naming.chromatic(Chromatic.GG): return Chromatic.GG;
            case Naming.chromatic(Chromatic.A): return Chromatic.A;
            case Naming.chromatic(Chromatic.AA): return Chromatic.AA;
            case Naming.chromatic(Chromatic.B): return Chromatic.B;
        }
        throw new Error("Can't convert '" + noteStr + "' to Chromatic.");
    }

    public static scale(scale: Scale): string {
        switch (scale) {
            case Scale.MAJOR: return Settings.scales.MAJOR;
            case Scale.MINOR: return Settings.scales.MINOR;
            case Scale.DORIAN: return Settings.scales.DORIAN;
            case Scale.PHRYGIAN: return Settings.scales.PHRYGIAN;
            case Scale.LYDIAN: return Settings.scales.LYDIAN;
            case Scale.MIXOLYDIAN: return Settings.scales.MIXOLYDIAN;
            case Scale.LOCRIAN: return Settings.scales.LOCRIAN;
            case Scale.HARMONIC_MINOR: return Settings.scales.HARMONIC_MINOR;
            case Scale.LOCRIAN_a6: return Settings.scales.LOCRIAN_a6;
            case Scale.IONIAN_a5: return Settings.scales.IONIAN_a5;
            case Scale.DORIAN_a4: return Settings.scales.DORIAN_a4;
            case Scale.MIXOLYDIAN_b9_b13: return Settings.scales.MIXOLYDIAN_b9_b13;
            case Scale.LYDIAN_a2: return Settings.scales.LYDIAN_a2;
            case Scale.SUPERLOCRIAN_bb7: return Settings.scales.SUPERLOCRIAN_bb7;
            case Scale.HARMONIC_MAJOR: return Settings.scales.HARMONIC_MAJOR;
            case Scale.DORIAN_b5: return Settings.scales.DORIAN_b5;
            case Scale.PHRYGIAN_b4: return Settings.scales.PHRYGIAN_b4;
            case Scale.LYDIAN_b3: return Settings.scales.LYDIAN_b3;
            case Scale.MIXOLYDIAN_b2: return Settings.scales.MIXOLYDIAN_b2;
            case Scale.AEOLIAN_b1: return Settings.scales.AEOLIAN_b1;
            case Scale.LOCRIAN_bb7: return Settings.scales.LOCRIAN_bb7;
            case Scale.MELODIC_MINOR: return Settings.scales.MELODIC_MINOR;
            case Scale.DORIAN_b2: return Settings.scales.DORIAN_b2;
            case Scale.LYDIAN_a5: return Settings.scales.LYDIAN_a5;
            case Scale.LYDIAN_b7: return Settings.scales.LYDIAN_b7;
            case Scale.MIXOLYDIAN_b13: return Settings.scales.MIXOLYDIAN_b13;
            case Scale.LOCRIAN_a2: return Settings.scales.LOCRIAN_a2;
            case Scale.SUPERLOCRIAN: return Settings.scales.SUPERLOCRIAN;
            case Scale.DOUBLE_HARMONIC: return Settings.scales.DOUBLE_HARMONIC;
            case Scale.LYDIAN_a2_a6: return Settings.scales.LYDIAN_a2_a6;
            case Scale.ULTRAPHRYGIAN: return Settings.scales.ULTRAPHRYGIAN;
            case Scale.HUNGARIAN_MINOR: return Settings.scales.HUNGARIAN_MINOR;
            case Scale.ORIENTAL: return Settings.scales.ORIENTAL;
            case Scale.IONIAN_AUGMENTED_a2: return Settings.scales.IONIAN_AUGMENTED_a2;
            case Scale.LOCRIAN_bb3_bb7: return Settings.scales.LOCRIAN_bb3_bb7;
            case Scale.NEAPOLITAN_MINOR: return Settings.scales.NEAPOLITAN_MINOR;
            case Scale.NEAPOLITAN_MAJOR: return Settings.scales.NEAPOLITAN_MAJOR;
            case Scale.BLUES_b5: return Settings.scales.BLUES_b5;
            case Scale.WHOLE_TONE: return Settings.scales.WHOLE_TONE;
            case Scale.PENTATONIC_MINOR: return Settings.scales.PENTATONIC_MINOR;
            case Scale.PENTATONIC: return Settings.scales.PENTATONIC;
            case Scale.EGYPCIAN: return Settings.scales.EGYPCIAN;
            case Scale.BLUES_MINOR: return Settings.scales.BLUES_MINOR;
            case Scale.BLUES_MAJOR: return Settings.scales.BLUES_MAJOR;
            case Scale.CHROMATIC: return Settings.scales.CHROMATIC;
            case Scale.AUGMENTED_TRIAD: return Settings.scales.AUGMENTED_TRIAD;
            case Scale.DIMINISHED_7th: return Settings.scales.DIMINISHED_7th;
            case Scale.MESSIAEN_V_TRUNCATED: return Settings.scales.MESSIAEN_V_TRUNCATED;
            case Scale.DOM7b5: return Settings.scales.DOM7b5;
            case Scale.MESSIAEN_INV_III_V_TRUNCATED_n2: return Settings.scales.MESSIAEN_INV_III_V_TRUNCATED_n2;
            case Scale.HALF_DIMINISHED: return Settings.scales.HALF_DIMINISHED;
            case Scale.MESSIAEN_V: return Settings.scales.MESSIAEN_V;
            case Scale.RAGA_INDRUPRIYA_INDIA: return Settings.scales.RAGA_INDRUPRIYA_INDIA;
            case Scale.MESSIAEN_II_TRUNCATED_n3: return Settings.scales.MESSIAEN_II_TRUNCATED_n3;
            case Scale.MESSIAEN_III_INV: return Settings.scales.MESSIAEN_III_INV;
            case Scale.MESSIAEN_IV: return Settings.scales.MESSIAEN_IV;
            case Scale.MESSIAEN_VI: return Settings.scales.MESSIAEN_VI;
            case Scale.MESSIAEN_VII: return Settings.scales.MESSIAEN_VII;
            case Scale.BEBOP_MAJOR: return Settings.scales.BEBOP_MAJOR;
        }

        return this.scaleToStringByIntervals(scale);
    }

    private static scaleToStringByIntervals(scale: Scale): string {
        let first = true;
        let ret: string = "";
        scale.intervals.forEach(i => {
            if (first)
                first = false;
            else
                ret += "-";
            ret += i;
        });

        return ret;
    }


    public static diatonic(diatonic: Diatonic): string {
        switch (diatonic) {
            case Diatonic.C: return Settings.lang.diatonic.C;
            case Diatonic.D: return Settings.lang.diatonic.D;
            case Diatonic.E: return Settings.lang.diatonic.E;
            case Diatonic.F: return Settings.lang.diatonic.F;
            case Diatonic.G: return Settings.lang.diatonic.G;
            case Diatonic.A: return Settings.lang.diatonic.A;
            case Diatonic.B: return Settings.lang.diatonic.B;
        }

        Error();
    }

    public static diatonicAlt(diatonicAlt: DiatonicAlt): string {
        return Naming.diatonic(diatonicAlt.diatonic) + Settings.symbols.alts(diatonicAlt.alts);
    }


    public static pattern(pattern: ChromaticChordPattern): string {
        switch ((<any>pattern).valuesHash) {
            case (<any>ChromaticChordPattern.TRIAD_MAJOR).valuesHash: return "MAJOR";
            case (<any>ChromaticChordPattern.TRIAD_MINOR).valuesHash: return "MINOR";
            case (<any>ChromaticChordPattern.TRIAD_AUGMENTED).valuesHash: return "AUGMENTED";
            case (<any>ChromaticChordPattern.TRIAD_DIMINISHED).valuesHash: return "DIMINISHED";
            case (<any>ChromaticChordPattern.TRIAD_SUS4).valuesHash: return "SUS4";
            case (<any>ChromaticChordPattern.TRIAD_QUARTAL).valuesHash: return "QUARTAL";
            case (<any>ChromaticChordPattern.ELEVENTH).valuesHash: return "ELEVENTH";
            case (<any>ChromaticChordPattern.ELEVENTH_MAJ11).valuesHash: return "ELEVENTH MAJ11";
            case (<any>ChromaticChordPattern.ELEVENTH_MINOR_MAJ11).valuesHash: return "ELEVENTH MINOR MAJ11";
            case (<any>ChromaticChordPattern.ELEVENTH_a9).valuesHash: return "ELEVENTH " + Settings.mods.a9;
            case (<any>ChromaticChordPattern.ELEVENTH_b9).valuesHash: return "ELEVENTH " + Settings.mods.b9;
            case (<any>ChromaticChordPattern.NINTH).valuesHash: return "NINTH";
            case (<any>ChromaticChordPattern.NINTH_ADD6).valuesHash: return "NINTH ADD6";
            case (<any>ChromaticChordPattern.NINTH_MAJ9).valuesHash: return "NINTH MAJ9";
            case (<any>ChromaticChordPattern.NINTH_MAJ9_a11).valuesHash: return "NINTH MAJ9 " + Settings.mods.a11;
            case (<any>ChromaticChordPattern.NINTH_MINOR).valuesHash: return "NINTH_MINOR";
            case (<any>ChromaticChordPattern.NINTH_MINOR_MAJ9).valuesHash: return "NINTH MINOR MAJ9";
            case (<any>ChromaticChordPattern.NINTH_SUS4).valuesHash: return "NINTH SUS4";
            case (<any>ChromaticChordPattern.NINTH_a11).valuesHash: return "NINTH " + Settings.mods.a11;
            case (<any>ChromaticChordPattern.NINTH_a5).valuesHash: return "NINTH " + Settings.mods.a5;
            case (<any>ChromaticChordPattern.NINTH_b5).valuesHash: return "NINTH " + Settings.mods.b5;
            case (<any>ChromaticChordPattern.POWER_CHORD).valuesHash: return "POWER CHORD";
            case (<any>ChromaticChordPattern.SEVENTH).valuesHash: return "SEVENTH";
            case (<any>ChromaticChordPattern.SEVENTH_ADD11).valuesHash: return "SEVENTH ADD11";
            case (<any>ChromaticChordPattern.SEVENTH_ADD13).valuesHash: return "SEVENTH ADD13";
            case (<any>ChromaticChordPattern.SEVENTH_MAJ7).valuesHash: return "SEVENTH MAJ7";
            case (<any>ChromaticChordPattern.SEVENTH_MINOR).valuesHash: return "SEVENTH MINOR";
            case (<any>ChromaticChordPattern.SEVENTH_MINOR_MAJ7).valuesHash: return "SEVENTH MINOR MAJ7";
            case (<any>ChromaticChordPattern.SEVENTH_MINOR_a5).valuesHash: return "SEVENTH MINOR " + Settings.mods.a5;
            case (<any>ChromaticChordPattern.SEVENTH_MINOR_b5).valuesHash: return "SEVENTH MINOR " + Settings.mods.b5;
            case (<any>ChromaticChordPattern.SEVENTH_MINOR_b9).valuesHash: return "SEVENTH MINOR " + Settings.mods.b9;
            case (<any>ChromaticChordPattern.SEVENTH_SUS4).valuesHash: return "SEVENTH SUS4";
            case (<any>ChromaticChordPattern.SEVENTH_a5).valuesHash: return "SEVENTH " + Settings.mods.a5;
            case (<any>ChromaticChordPattern.SEVENTH_a9).valuesHash: return "SEVENTH " + Settings.mods.a9;
            case (<any>ChromaticChordPattern.SEVENTH_b5).valuesHash: return "SEVENTH " + Settings.mods.b5;
            case (<any>ChromaticChordPattern.SEVENTH_b9).valuesHash: return "SEVENTH " + Settings.mods.b9;
            case (<any>ChromaticChordPattern.SIXTH).valuesHash: return "SIXTH";
            case (<any>ChromaticChordPattern.SIXTH_ADD9).valuesHash: return "SIXTH ADD9";
            case (<any>ChromaticChordPattern.SIXTH_MINOR).valuesHash: return "SIXTH MINOR";
            case (<any>ChromaticChordPattern.SIXTH_MINOR_ADD9).valuesHash: return "SIXTH MINOR ADD9";
            case (<any>ChromaticChordPattern.SIXTH_SUS4).valuesHash: return "SIXTH SUS4";
            case (<any>ChromaticChordPattern.THIRTEENTH_MAJ13).valuesHash: return "THIRTEENTH MAJ13";
            case (<any>ChromaticChordPattern.THIRTEENTH_MAJ13_a5).valuesHash: return "THIRTEENTH MAJ13 " + Settings.mods.a5;
            case (<any>ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9).valuesHash: return "THIRTEENTH MAJ13 " + Settings.mods.a5 + Settings.mods.a9;
        }
        return pattern.values.toString();
    }

    public static patternShort(pattern: ChromaticChordPattern): string {
        switch ((<any>pattern).valuesHash) {
            case (<any>(<any>ChromaticChordPattern.TRIAD_MAJOR)).valuesHash: return "";
            case (<any>ChromaticChordPattern.TRIAD_MINOR).valuesHash: return "m";
            case (<any>ChromaticChordPattern.TRIAD_AUGMENTED).valuesHash: return "+";
            case (<any>ChromaticChordPattern.TRIAD_DIMINISHED).valuesHash: return "dim";
            case (<any>ChromaticChordPattern.TRIAD_SUS4).valuesHash: return "sus4";
            case (<any>ChromaticChordPattern.TRIAD_QUARTAL).valuesHash: return "quartal";
            case (<any>ChromaticChordPattern.ELEVENTH).valuesHash: return "11";
            case (<any>ChromaticChordPattern.ELEVENTH_MAJ11).valuesHash: return "Maj11";
            case (<any>ChromaticChordPattern.ELEVENTH_MINOR_MAJ11).valuesHash: return "mMaj11";
            case (<any>ChromaticChordPattern.ELEVENTH_a9).valuesHash: return "11#9";
            case (<any>ChromaticChordPattern.ELEVENTH_b9).valuesHash: return "11b9";
            case (<any>ChromaticChordPattern.NINTH).valuesHash: return "9";
            case (<any>ChromaticChordPattern.NINTH_ADD6).valuesHash: return "9add6";
            case (<any>ChromaticChordPattern.NINTH_MAJ9).valuesHash: return "Maj9";
            case (<any>ChromaticChordPattern.NINTH_MAJ9_a11).valuesHash: return "Maj9#11";
            case (<any>ChromaticChordPattern.NINTH_MINOR).valuesHash: return "m9";
            case (<any>ChromaticChordPattern.NINTH_MINOR_MAJ9).valuesHash: return "mMaj9";
            case (<any>ChromaticChordPattern.NINTH_SUS4).valuesHash: return "9sus4";
            case (<any>ChromaticChordPattern.NINTH_a11).valuesHash: return "9" + Settings.mods.a11;
            case (<any>ChromaticChordPattern.NINTH_a5).valuesHash: return "9" + Settings.mods.a5;
            case (<any>ChromaticChordPattern.NINTH_b5).valuesHash: return "9" + Settings.mods.b5;
            case (<any>ChromaticChordPattern.POWER_CHORD).valuesHash: return "5";
            case (<any>ChromaticChordPattern.SEVENTH).valuesHash: return "7";
            case (<any>ChromaticChordPattern.SEVENTH_ADD11).valuesHash: return "7add11";
            case (<any>ChromaticChordPattern.SEVENTH_ADD13).valuesHash: return "7add13";
            case (<any>ChromaticChordPattern.SEVENTH_MAJ7).valuesHash: return "Maj7";
            case (<any>ChromaticChordPattern.SEVENTH_MINOR).valuesHash: return "m7";
            case (<any>ChromaticChordPattern.SEVENTH_MINOR_MAJ7).valuesHash: return "mMaj7";
            case (<any>ChromaticChordPattern.SEVENTH_MINOR_a5).valuesHash: return "m7" + Settings.mods.a5;
            case (<any>ChromaticChordPattern.SEVENTH_MINOR_b5).valuesHash: return "m7" + Settings.mods.b5;
            case (<any>ChromaticChordPattern.SEVENTH_MINOR_b9).valuesHash: return "m7" + Settings.mods.b9;
            case (<any>ChromaticChordPattern.SEVENTH_SUS4).valuesHash: return "7sus4";
            case (<any>ChromaticChordPattern.SEVENTH_a5).valuesHash: return "7" + Settings.mods.a5;
            case (<any>ChromaticChordPattern.SEVENTH_a9).valuesHash: return "7" + Settings.mods.a9;
            case (<any>ChromaticChordPattern.SEVENTH_b5).valuesHash: return "7" + Settings.mods.b5;
            case (<any>ChromaticChordPattern.SEVENTH_b9).valuesHash: return "7" + Settings.mods.b9;
            case (<any>ChromaticChordPattern.SIXTH).valuesHash: return "6";
            case (<any>ChromaticChordPattern.SIXTH_ADD9).valuesHash: return "6add9";
            case (<any>ChromaticChordPattern.SIXTH_MINOR).valuesHash: return "m6";
            case (<any>ChromaticChordPattern.SIXTH_MINOR_ADD9).valuesHash: return "m6add9";
            case (<any>ChromaticChordPattern.SIXTH_SUS4).valuesHash: return "6sus4";
            case (<any>ChromaticChordPattern.TRIAD_SUS4).valuesHash: return "sus4";
            case (<any>ChromaticChordPattern.THIRTEENTH_MAJ13).valuesHash: return "Maj13";
            case (<any>ChromaticChordPattern.THIRTEENTH_MAJ13_a5).valuesHash: return "Maj13" + Settings.mods.a5;
            case (<any>ChromaticChordPattern.THIRTEENTH_MAJ13_a5a9).valuesHash: return "Maj13" + Settings.mods.a5 + Settings.mods.a9;
        }

        return pattern.values.toString();
    }

    public static tonality(tonality: Tonality) {
        return Naming.diatonicAlt(tonality.root) + " " + Naming.scale(tonality.scale);
    }
}