import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { TonalityPrecalc } from './TonalityPrecalc';
import { ScalePrecalc } from './ScalePrecalc';

test('Tonality - predefined: ', () => {
    expect(TonalityPrecalc.C.scale).toBe(ScalePrecalc.MAJOR);
    expect(TonalityPrecalc.C.root).toBe(DiatonicAlt.C);
});