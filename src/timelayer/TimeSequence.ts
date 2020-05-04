import { Time } from 'tempo/Time';
import TreeMap from 'ts-treemap';
import { DurableEvent } from './DurableEvent';
import { TimeLayer } from './TimeLayer';

export class TimeSequence<E, C extends DurableEvent<E, T>, T extends Time> implements TimeLayer<E[], T> {
    private cells: TreeMap<number, C[]>;
    private cellSize: T;

    protected constructor(cellSize: T) {
        this.cellSize = cellSize;
        this.cells = new TreeMap();
    }

    private getCellIndex(time: T): number {
        return time.getDivCell(this.cellSize);
    }

    private getCellFromTime(time: T): C[] {
        let index: number = this.getCellIndex(time);
        return this.getCellFromIndex(index);
    }

    private getCellFromIndex(index: number): C[] {
        let cell = this.cells.get(index);
        if (!cell)
            return [];
    }

    public add(durableEvent: C): void {
        let posCell: number = this.getCellIndex(durableEvent.ini);
        let endCell: number = this.getCellIndex(durableEvent.end);

        for (let i: number = posCell; i <= endCell; i++) {
            let cell: C[] = this.getCellFromIndex(i);

            cell.push(durableEvent);
        }
    }

    public getEvents(time: T): C[] {
        let ret: C[] = [];

        let cell: C[] = this.getCellFromTime(time);
        for (let musicalEvent of cell) {
            if (time.isBetween(musicalEvent.ini, musicalEvent.end))
                ret.push(musicalEvent);
        }

        return ret;
    }

    public get(time: T): E[] {
        let ret: E[] = [];

        let cell: C[] = this.getCellFromTime(time);
        for (let musicalEvent of cell) {
            if (time.isBetween(musicalEvent.ini, musicalEvent.end))
                ret.push(musicalEvent.event);
        }

        return ret;
    }

    public getLength(): T {
        let lastCell: C[] = this.cells.lastEntry()[1];
        let max: T = lastCell[0].end;
        for (let i: number = 1; i < lastCell.length; i++) {
            let c: C = lastCell[i];
            if (c.end.compareTo(max) > 0)
                max = c.end;
        }
        return max;
    }

    public remove(time: T): void {
        let cell: C[] = this.getCellFromTime(time);
        for (let c of cell) {
            if (time.isBetween(c.ini, c.end)) {
                let index = cell.indexOf(c);
                cell.splice(index);
            }
        }
    }
}