import { ParserBottomUp } from "./Parser";
import { Diatonic } from "../../degrees/Diatonic";

import * as precalc from "../../precalc";
precalc.chromatics();
precalc.diatonics();
precalc.diatonicAlts();
precalc.intervalDiatonicAlts();
precalc.settings();

test('CD - diatonic diatonic', () => {
    let str = "CD";
    let parser = new ParserBottomUp()
    .add(Diatonic.name, function(str:string): Diatonic {
        return Diatonic.fromString(str);
    })
    .from(str)
    .expected([Diatonic.name, Diatonic.name]);

    let actual = parser.parse();
    let expected = [Diatonic.C, Diatonic.D];
    
    expect(actual).toEqual(expected);
});