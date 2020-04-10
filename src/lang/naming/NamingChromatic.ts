import { Chromatic } from '../../degrees/Chromatic';
import { Naming } from './Naming';
import { Diatonic } from '../../degrees/Diatonic';
import { Settings } from '../../settings/Settings';

export class NamingChromatic {
    private constructor() {
    }
    
    public static toString(chromatic: Chromatic): string {
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
        .replace(/'#'/g, Settings.symbols.sharp)
        .replace(/'b'/g, Settings.symbols.bemol);

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