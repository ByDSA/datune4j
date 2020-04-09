import { SourceScaleUtils } from './SourceScaleUtils';
import { Scale } from './Scale';

test('SourceScaleUtils - getSourceScaleFrom: ', () => {
    for (let scale of Scale.all) {
        let sourceScale = SourceScaleUtils.getSourceScaleFrom(scale);
        expect(sourceScale).not.toBe(undefined);
        expect(sourceScale).not.toBe(null);
    }
});