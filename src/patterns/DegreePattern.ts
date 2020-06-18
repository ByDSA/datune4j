export interface DegreePattern<D, I> {
    rootIndex: number;
    inversionNumber: number;
    shortName: string;
    getInv(n: number): DegreePattern<D, I>;

    rootIntervals: I[];

    length: number;
}