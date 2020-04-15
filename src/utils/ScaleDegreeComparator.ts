import { DiatonicAltDegree } from '../degrees/scale/DiatonicAltDegree';
import { Scale } from '../tonality/Scale';

export class CommonDifferentCalculator {
    private _common = new Set<DiatonicAltDegree>();
    private _different = new Set<DiatonicAltDegree>();
    private calculated: boolean;

    private constructor(private scales: Scale[], private enharmonic: boolean) {
        this.calculated = false;
    }

    public static from(scales: Scale[], enharmonic = true): CommonDifferentCalculator {
        return new CommonDifferentCalculator(scales, enharmonic);
    }

    public calculate(): void {
        this.addAllScaleDegreesToCommon();
        if (this.enharmonic)
            this.removeNonCommonDegreesEnharmonic();
        else
            this.removeNonCommonDegreesNonEnharmonic();
        this.calculated = true;
    }

    private addAllScaleDegreesToCommon(): void {
        for (let scale of this.scales)
            for (let degree of scale.degrees)
                this._common.add(degree);
    }

    private removeNonCommonDegreesEnharmonic(): void {
        mainFor: for (let degree of this._common)
            for (let scale of this.scales) {
                if (!scale.degrees.map(degree => degree.semis).includes(degree.semis)) {
                    this._common.delete(degree)
                    this._different.add(degree);
                    continue mainFor;
                }
            }
    }

    private removeNonCommonDegreesNonEnharmonic(): void {
        mainFor: for (let degree of this._common)
            for (let scale of this.scales) {
                if (!scale.degrees.includes(degree)) {
                    this._common.delete(degree)
                    this._different.add(degree);
                    continue mainFor;
                }
            }
    }

    public get common(): Set<DiatonicAltDegree> {
        this.errorIfNotCalculated();
        return this._common;
    }
    
    public get different(): Set<DiatonicAltDegree> {
        this.errorIfNotCalculated();
        return this._different;
    }

    private errorIfNotCalculated() {
        if (!this.calculated)
            throw new Error("Not calculated yet");
    }
}