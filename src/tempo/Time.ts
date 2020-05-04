export interface Time {
    getAdd(time: Time): Time;

    getSub(time: Time): Time;

    getMult(factor: number): Time;

    getDivCell(cellSize: Time): number;

    getDiv(n: number): Time;

    isBetween(a: Time, b: Time): boolean;

    compareTo(time: Time): number;

    clone(): Time;
}