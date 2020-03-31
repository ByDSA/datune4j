import { Chromatic } from './Chromatic'
import { Diatonic } from './Diatonic';
import { DiatonicAlt } from './DiatonicAlt';
import { MathUtils } from './MathUtils';
import { IntervalChromatic } from './IntervalChromatic';

export class ChromaticUtils {
    public static NUMBER = 12;

    static fromDiatonicAlt(diatonicAlt: DiatonicAlt): Chromatic {
        let chromatic = ChromaticUtils.fromDiatonic(diatonicAlt.getDiatonic());
        chromatic += diatonicAlt.getAlts();
        chromatic = MathUtils.rotativeTrim(chromatic, ChromaticUtils.NUMBER);

        return chromatic;
    }

    static fromDiatonic(diatonic: Diatonic): Chromatic {
        switch (diatonic) {
            case Diatonic.C: return Chromatic.C;
            case Diatonic.D: return Chromatic.D;
            case Diatonic.E: return Chromatic.E;
            case Diatonic.F: return Chromatic.F;
            case Diatonic.G: return Chromatic.G;
            case Diatonic.A: return Chromatic.A;
            case Diatonic.B: return Chromatic.B;
        }
    }

    public static getShifted(root: Chromatic, intervalChromatic: IntervalChromatic): Chromatic {
        return ChromaticUtils.getShiftedBySemis(root, intervalChromatic.getSemis());
    }

    public static getShiftedBySemis(root: Chromatic, semis: number): Chromatic {
        return MathUtils.rotativeTrim(root + semis, ChromaticUtils.NUMBER);
    }

    public static toString(chromatic: Chromatic): string {
        switch (chromatic) {
            case Chromatic.C: return "C";
            case Chromatic.CC: return "C#";
            case Chromatic.D: return "D";
            case Chromatic.DD: return "D#";
            case Chromatic.E: return "E";
            case Chromatic.F: return "F";
            case Chromatic.FF: return "F#";
            case Chromatic.G: return "G";
            case Chromatic.GG: return "G#";
            case Chromatic.A: return "A";
            case Chromatic.AA: return "A#";
            case Chromatic.B: return "B";
        }

        return "";
    }

    public static toStringParams(chromatic: Chromatic) {
        return this.toString(chromatic);
    }

    static fromString(noteStr: string): Chromatic {
        switch (noteStr) {
            case "C": return Chromatic.C;
            case "C#": return Chromatic.CC;
            case "D": return Chromatic.D;
            case "D#": return Chromatic.DD;
            case "E": return Chromatic.E;
            case "F": return Chromatic.F;
            case "F#": return Chromatic.FF;
            case "G": return Chromatic.G;
            case "G#": return Chromatic.GG;
            case "A": return Chromatic.A;
            case "A#": return Chromatic.AA;
            case "B": return Chromatic.B;
        }
        throw new Error("Can't convert '" + noteStr + "' to Chromatic.");
    }
}