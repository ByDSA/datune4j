import { DiatonicAltDegree } from 'degrees/scale/DiatonicAltDegree';
import { Scale } from './tonality/Scale';

export class CommonDifferentCalculator {
    private _common = new Set<DiatonicAltDegree>();
    private _different = new Set<DiatonicAltDegree>();

    private constructor(private scales: Scale[], private enharmonic: boolean) {
    }

    public static from(scales: Scale[], enharmonic = true): CommonDifferentCalculator {
        return new CommonDifferentCalculator(scales, enharmonic);
    }

    public calculate(): void {
        this.addAllScaleDegreesToCommon();
        this.removeNonCommonDegreesEnharmonic();
    }

    private addAllScaleDegreesToCommon(): void {
        for (let scale of this.scales)
            for (let degree of scale.degrees)
                this._common.add(degree);
    }

    private removeNonCommonDegreesEnharmonic(): void {
        mainFor: for (let degree of this._common)
            for (let scale of this.scales) {
                if (!this.enharmonic && !scale.degrees.includes(degree) ||
                    this.enharmonic && !scale.degrees.map(degree => degree.semis).includes(degree.semis)) {
                    this._common.delete(degree)
                    this._different.add(degree);
                    continue mainFor;
                }
            }
    }

    public get common(): Set<DiatonicAltDegree> {
        return this._common;
    }

    public get different(): Set<DiatonicAltDegree> {
        return this._different;
    }
}