import { Scale } from './Scale';
import { SourceScaleUtils } from './SourceScaleUtils';
require('../precalc');

test('SourceScaleUtils - getSourceScaleFrom: ', () => {
    for (let scale of Scale.all()) {
        let sourceScale = SourceScaleUtils.getSourceScaleFrom(scale);
        expect(sourceScale).not.toBe(undefined);
        expect(sourceScale).not.toBe(null);
    }
});