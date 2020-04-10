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