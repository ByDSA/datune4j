import { ChromaticChordPattern } from '../../chords/chromatic/ChromaticChordPattern';
import { Diatonic } from '../../degrees/Diatonic';
import { DiatonicAlt } from '../../degrees/DiatonicAlt';
import { Settings } from '../../settings/Settings';
import { Scale } from '../../tonality/Scale';
import { ScaleUtils } from '../../tonality/ScaleUtils';
import { Tonality } from '../../tonality/Tonality';
import { NamingScale } from './NamingScale';

export class Naming {
    private constructor() {
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
        return tonality.root.toString() + " " + NamingScale.toString(tonality.scale);
    }

    public static aboluteIntervals(scale: Scale): string {
        let absoluteIntervals = scale.absoluteIntervals;

        let first = true;
        let ret: string = "";
        let i = 1;
        absoluteIntervals.forEach(n => {
            if (first)
                first = false;
            else
                ret += "-";
            let refNum = ScaleUtils.getRefNum(scale, i);
            ret += Naming.absoluteInterval(refNum, n);
            i++;
        });

        return ret;
    }

    public static absoluteInterval(pos: number, intervalAbsolute: number): string {
        return Settings.symbols.alts(intervalAbsolute - Scale.MAJOR.absoluteIntervals[pos - 1]) + pos;
    }
}