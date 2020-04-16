import { IntervalDiatonicAlt } from "../../interval/IntervalDiatonicAlt";
import * as precalc from "../../precalc";
import { DiatonicAltDegree } from "./DiatonicAltDegree";
precalc.diatonicAltDegrees();
precalc.intervalDiatonicAlts();
precalc.chromatics();
precalc.scales();

test('DiatonicAltDegree- getAdd: bVII + a1 = VII', () => {
    let diatonicAltDegree = DiatonicAltDegree.bVII;
    let intervalDiatonicAlt = IntervalDiatonicAlt.from(1, 0);

    let sum = diatonicAltDegree.getAdd(intervalDiatonicAlt);
    let expected = DiatonicAltDegree.VII;

    expect(sum).toEqual(expected);
});