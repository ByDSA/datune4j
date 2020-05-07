export interface DegreePattern<D> {
    rootIndex: number;
    shortName: string;
    getInv(n: number): DegreePattern<D>;
}