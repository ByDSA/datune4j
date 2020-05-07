import { Degree } from '../degrees/Degree';
import { DegreePattern } from '../patterns/DegreePattern';

export interface Chord<D extends Degree> {
    pattern: DegreePattern<D>
    rootIndex: number;
    notes: D[];
    inversionNumber: number;
    root: D;
    getInv(n: number): Chord<D>;
}