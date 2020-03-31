export class CommonDifferentCalculator {
    constructor(scales) {
        this.scales = scales;
        this.common = new Set();
        this.different = new Set();
    }
    static from(scales) {
        return new CommonDifferentCalculator(scales);
    }
    calculate() {
        this.addAllAbsoluteIntervalsToCommon();
        this.removeAbsoluteIntervalsFromCommon();
    }
    addAllAbsoluteIntervalsToCommon() {
        for (let scale of this.scales) {
            let absoluteIntervals = scale.getAbsoluteIntervals();
            for (let absoluteInterval of absoluteIntervals)
                this.common.add(absoluteInterval);
        }
    }
    removeAbsoluteIntervalsFromCommon() {
        mainFor: for (let absoluteInterval of this.common)
            for (let scale of this.scales) {
                if (!scale.hasAbsoluteInterval(absoluteInterval)) {
                    this.common.delete(absoluteInterval);
                    this.different.add(absoluteInterval);
                    continue mainFor;
                }
            }
    }
    getCommon() {
        return this.common;
    }
    getDifferent() {
        return this.different;
    }
}
//# sourceMappingURL=CommonDifferentCalculator.js.map