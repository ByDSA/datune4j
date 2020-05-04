import TreeMap from 'ts-treemap';
import { Time } from '../tempo/Time';
import { Interval } from '../utils/Interval';
import { DurableEvent } from './DurableEvent';
import { TimeLayer } from './TimeLayer';

export abstract class TimeSequence<E, DurEv extends DurableEvent<E, T>, T extends Time>
    implements TimeLayer<E[], T> {

    private cells: TreeMap<number, DurEv[]>;
    private _events: DurEv[];

    protected constructor(private _cellSize: T) {
        this.cells = new TreeMap();
        this._events = [];
    }

    private getCellIndex(time: T): number {
        return time.getDivCell(this._cellSize);
    }

    private getCellFromTime(time: T): DurEv[] {
        let index: number = this.getCellIndex(time);
        return this.getCellFromIndex(index);
    }

    private getCellFromIndex(index: number): DurEv[] {
        let cell = this.cells.get(index);
        if (!cell) {
            cell = [];
            this.cells.set(index, cell);
        }

        return cell;
    }

    public add(durableEvent: DurEv): void {
        let iniCell: number = this.getCellIndex(durableEvent.from);
        let endCell: number = this.getCellIndex(durableEvent.to);

        // Fix open Interval
        if (durableEvent.to == this.cellSize.getMult(endCell))
            endCell--;

        for (let i: number = iniCell; i <= endCell; i++) {
            let cell: DurEv[] = this.getCellFromIndex(i);

            cell.push(durableEvent);
        }

        this._events.push(durableEvent);
    }

    public getAtInterval(interval: Interval<T>): DurEv[] {
        let iniCell: number = this.getCellIndex(interval.from);
        let endCell: number = this.getCellIndex(interval.to);

        let ret: DurEv[] = [];
        for (let i: number = iniCell; i <= endCell; i++) {
            let cell: DurEv[] = this.getCellFromIndex(i);

            for (let musicalEvent of cell) {
                if (interval.intersects(musicalEvent.interval))
                    ret.push(musicalEvent);
            }
        }

        return ret;
    }

    public getAtTime(time: T): DurEv[] {
        let ret: DurEv[] = [];

        let cell: DurEv[] = this.getCellFromTime(time);
        for (let musicalEvent of cell) {
            if (time >= musicalEvent.from && time <= musicalEvent.to)
                ret.push(musicalEvent);
        }

        return ret;
    }

    public get duration(): T {
        let lastCell: DurEv[] = this.cells.lastEntry()[1];
        let max: T = lastCell[0].to;
        for (let i: number = 1; i < lastCell.length; i++) {
            let c: DurEv = lastCell[i];
            if (c.to > max)
                max = c.to;
        }
        return max;
    }

    public get events(): DurEv[] {
        return this._events;
    }

    public removeAtTime(time: T): void {
        let cell: DurEv[] = this.getCellFromTime(time);
        for (let i = 0; i < cell.length; i++) {
            let c: DurEv = cell[i];
            if (c.interval.contains(time)) {
                cell.splice(i, 1);

                let indexEvents = this._events.indexOf(c);
                this._events.splice(indexEvents, 1);
                i--;
            }
        }
    }

    public get cellSize(): T {
        return this._cellSize;
    }
}