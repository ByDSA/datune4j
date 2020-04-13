import { DiatonicAltChord } from '../chords/diatonicalt/DiatonicAltChord';
import { TonalChord } from '../chords/tonal/TonalChord';
import { Tonality } from '../tonality/Tonality';

export abstract class HarmonicFunction {
    private static functionCache = new Map<string, DiatonicAltChord>();

    public getChord(tonality: Tonality): DiatonicAltChord | null {
        let tonalChord: TonalChord = TonalChord.from(tonality, this);
        let tonalChordHashCode = tonalChord.hashCode();
        let diatonicAltChord = HarmonicFunction.functionCache.get(tonalChordHashCode);
        if (diatonicAltChord == undefined) {
            diatonicAltChord = this.calculateChord(tonality);
            HarmonicFunction.functionCache.set(tonalChordHashCode, diatonicAltChord);
        }
        return diatonicAltChord;
    }

    protected abstract calculateChord(tonality: Tonality): DiatonicAltChord | null;
}