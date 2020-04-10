import { DiatonicAlt } from '../degrees/DiatonicAlt';
import { Scale } from './Scale';
import { Tonality } from './Tonality';
require('../precalc')

test('Tonality - predefined: ', () => {
    expect(Tonality.C.scale).toBe(Scale.MAJOR);
    expect(Tonality.C.root).toBe(DiatonicAlt.C);
});