import { Scale } from './Scale';
import { SourceScaleUtils } from './SourceScaleUtils';
import * as precalc from "../precalc";
precalc.scales();
precalc.sourceScales();

test('SourceScaleUtils - getSourceScaleFrom: ', () => {
    for (let scale of Scale.all()) {
        let sourceScale = SourceScaleUtils.getSourceScaleFrom(scale);
        expect(sourceScale).not.toBe(undefined);
        expect(sourceScale).not.toBe(null);
    }
});