import { IntervalDiatonicAlt } from "../../interval/IntervalDiatonicAlt";
import * as precalc from "../../precalc";
import { DiatonicAltDegree } from "./DiatonicAltDegree";
import { DiatonicDegree } from "./DiatonicDegree";
import { IntervalDiatonic } from "../../interval/IntervalDiatonic";
precalc.diatonicAltDegrees();
precalc.intervalDiatonicAlts();
precalc.intervalDiatonics();
precalc.chromatics();
precalc.scales();

test('DiatonicAltDegree- getAdd: bVII + a1 = VII', () => {
    let diatonicAltDegree = DiatonicAltDegree.bVII;
    let intervalDiatonic = IntervalDiatonic.UNISON;
    let intervalDiatonicAlt = IntervalDiatonicAlt.from(1, intervalDiatonic);

    let sum = diatonicAltDegree.getAdd(intervalDiatonicAlt);
    let expected = DiatonicAltDegree.VII;

    expect(sum).toEqual(expected);
});

test('DiatonicAltDegree- semis: bI.semis == VII.semis', () => {
    let diatonicAltDegree1 = DiatonicAltDegree.from(DiatonicDegree.I, -1);
    let diatonicAltDegree2 = DiatonicAltDegree.VII;

    expect(diatonicAltDegree1.semis).toEqual(diatonicAltDegree2.semis);
});