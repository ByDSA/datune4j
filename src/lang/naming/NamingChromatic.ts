import { Chromatic } from '../../degrees/Chromatic';
import { Diatonic } from '../../degrees/Diatonic';
import { Settings } from '../../settings/Settings';

export class NamingChromatic {
    private constructor() {
    }

    public static toString(chromatic: Chromatic): string {
        switch (chromatic) {
            case Chromatic.C: return Diatonic.C.toString();
            case Chromatic.CC: return Diatonic.C.toString() + Settings.symbols.alts(1);
            case Chromatic.D: return Diatonic.D.toString();
            case Chromatic.DD: return Diatonic.D.toString() + Settings.symbols.alts(1);
            case Chromatic.E: return Diatonic.E.toString();
            case Chromatic.F: return Diatonic.F.toString();
            case Chromatic.FF: return Diatonic.F.toString() + Settings.symbols.alts(1);
            case Chromatic.G: return Diatonic.G.toString();
            case Chromatic.GG: return Diatonic.G.toString() + Settings.symbols.alts(1);
            case Chromatic.A: return Diatonic.A.toString();
            case Chromatic.AA: return Diatonic.A.toString() + Settings.symbols.alts(1);
            case Chromatic.B: return Diatonic.B.toString();
        }

        throw new Error("Can't get string from '" + chromatic + "'.");
    }

    static getChromatic(noteStr: string): Chromatic {
        noteStr = noteStr
            .replace(/#/g, Settings.symbols.sharp)
            .replace(/b/g, Settings.symbols.bemol);

        switch (noteStr) {
            case NamingChromatic.toString(Chromatic.C): return Chromatic.C;
            case NamingChromatic.toString(Chromatic.CC): return Chromatic.CC;
            case NamingChromatic.toString(Chromatic.D): return Chromatic.D;
            case NamingChromatic.toString(Chromatic.DD): return Chromatic.DD;
            case NamingChromatic.toString(Chromatic.E): return Chromatic.E;
            case NamingChromatic.toString(Chromatic.F): return Chromatic.F;
            case NamingChromatic.toString(Chromatic.FF): return Chromatic.FF;
            case NamingChromatic.toString(Chromatic.G): return Chromatic.G;
            case NamingChromatic.toString(Chromatic.GG): return Chromatic.GG;
            case NamingChromatic.toString(Chromatic.A): return Chromatic.A;
            case NamingChromatic.toString(Chromatic.AA): return Chromatic.AA;
            case NamingChromatic.toString(Chromatic.B): return Chromatic.B;
        }
        throw new Error("Can't convert '" + noteStr + "' to Chromatic.");
    }
}