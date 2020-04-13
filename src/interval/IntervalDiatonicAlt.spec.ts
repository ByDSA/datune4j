import { DiatonicAlt } from '../degrees/DiatonicAlt';
import * as precalc from "../precalc";
import { IntervalDiatonicAlt } from './IntervalDiatonicAlt';
precalc.chromatics();
precalc.diatonicAlts();

test('IntervalDiatonicAlt - fromRootNotes: get from ImmutableCache', () => {
    let intervalDiatonicAlt = IntervalDiatonicAlt.between(DiatonicAlt.C, DiatonicAlt.E)
    let expected = IntervalDiatonicAlt.MAJOR_THIRD;
    expect(intervalDiatonicAlt).toBe(expected);
});