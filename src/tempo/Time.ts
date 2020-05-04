export interface Time {
    getAdd(time: Time): Time;

    getSub(time: Time): Time;

    getMult(factor: number): Time;

    getDivCell(cellSize: Time): number;

    getDiv(n: number): Time;

    valueOf(): number;

    clone(): Time;
}