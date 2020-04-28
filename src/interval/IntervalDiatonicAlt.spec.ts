import { DiatonicAlt } from '../degrees/DiatonicAlt';
import * as precalc from "../precalc";
import { IntervalDiatonicAlt } from './IntervalDiatonicAlt';
precalc.chromatics();
precalc.diatonicAlts();
precalc.intervalDiatonicAlts();

test('IntervalDiatonicAlt - fromRootNotes: get from ImmutableCache', () => {
    let intervalDiatonicAlt = IntervalDiatonicAlt.betweenDiatonicAlt(DiatonicAlt.C, DiatonicAlt.E)
    let expected = IntervalDiatonicAlt.MAJOR_THIRD;
    expect(intervalDiatonicAlt).toBe(expected);
});