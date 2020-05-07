export interface DegreePattern<D> {
    rootIndex: number;
    inversionNumber: number;
    shortName: string;
    getInv(n: number): DegreePattern<D>;
}