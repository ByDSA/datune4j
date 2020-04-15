import { Settings } from '../../settings/Settings';
import { Scale } from '../../tonality/Scale';
import { Tonality } from '../../tonality/Tonality';
import { NamingScale } from './NamingScale';

export class Naming {
    private constructor() {
    }

    public static tonality(tonality: Tonality) {
        return tonality.root.toString() + " " + NamingScale.toString(tonality.scale);
    }

    public static aboluteIntervals(scale: Scale): string {
        let degrees = scale.degrees;

        let first = true;
        let ret: string = "";
        let i = 1;
        let acc = 0;
        degrees.forEach(n => {
            if (first)
                first = false;
            else
                ret += "-";
            acc += n.semis;
            let refNum = scale.reparametrizer(i, acc);
            ret += Naming.absoluteInterval(refNum, n.semis);
            i++;
        });

        return ret;
    }

    public static absoluteInterval(pos: number, intervalAbsolute: number): string {
        return Settings.symbols.alts(intervalAbsolute - Scale.MAJOR.degrees[pos - 1].semis) + pos;
    }
}