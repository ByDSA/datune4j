import { SourceScaleUtils } from './SourceScaleUtils';
import { ScalePrecalc } from './ScalePrecalc';

test('SourceScaleUtils - getSourceScaleFrom: ', () => {
    for (let scale of ScalePrecalc.all) {
        let sourceScale = SourceScaleUtils.getSourceScaleFrom(scale);
        expect(sourceScale).not.toBe(undefined);
        expect(sourceScale).not.toBe(null);
    }
});