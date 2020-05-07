import TreeMap from 'ts-treemap';
import { Time } from '../tempo/Time';
import { Interval } from '../utils/Interval';
import { TemporalEvent } from './TemporalEvent';
import { TemporalNode } from './TemporalNode';
import { TimeLayer } from './TimeLayer';

export abstract class TimeSequence<E extends TemporalEvent<T>, T extends Time>
    implements TimeLayer<E[], T>, TemporalEvent<T> {

    private cells: TreeMap<number, TemporalNode<E, T>[]>;
    private _nodes: TemporalNode<E, T>[];

    protected constructor(private _cellSize: T) {
        this.cells = new TreeMap();
        this._nodes = [];
    }

    private getCellIndex(time: T): number {
        return time.getDivCell(this._cellSize);
    }

    private getCellFromTime(time: T): TemporalNode<E, T>[] {
        let index: number = this.getCellIndex(time);
        return this.getCellFromIndex(index);
    }

    private getCellFromIndex(index: number): TemporalNode<E, T>[] {
        let cell = this.cells.get(index);
        if (!cell) {
            cell = [];
            this.cells.set(index, cell);
        }

        return cell;
    }

    public add(durableEvent: TemporalNode<E, T>): void {
        let iniCell: number = this.getCellIndex(durableEvent.from);
        let endCell: number = this.getCellIndex(durableEvent.to);

        // Fix open Interval
        if (durableEvent.to == this.cellSize.getMult(endCell))
            endCell--;

        for (let i: number = iniCell; i <= endCell; i++) {
            let cell: TemporalNode<E, T>[] = this.getCellFromIndex(i);

            cell.push(durableEvent);
        }

        this._nodes.push(durableEvent);
    }

    public addSequenceAt(time: T, timeSequence: TimeSequence<E, T>): void {
        for (let eventSource of timeSequence.nodes) {
            let event: TemporalNode<E, T> = <TemporalNode<E, T>> TemporalNode.createFrom(time.getAdd(eventSource.from), eventSource.event);
            this.add(event);
        }
    }

    public addAt(time: T, temporalEvent: E): void {
        let event = TemporalNode.createFrom(time, temporalEvent);
        this.add(event);

    }

    public addSequence(midiSequence: TimeSequence<E, T>): void {
        this.addSequenceAt(this.duration, midiSequence)
    }

    public getAtInterval(interval: Interval<T>): TemporalNode<E, T>[] {
        let iniCell: number = this.getCellIndex(interval.from);
        let endCell: number = this.getCellIndex(interval.to);

        let ret: TemporalNode<E, T>[] = [];
        for (let i: number = iniCell; i <= endCell; i++) {
            let cell: TemporalNode<E, T>[] = this.getCellFromIndex(i);

            for (let node of cell) {
                if (interval.intersects(node.interval))
                    ret.push(node);
            }
        }

        return ret;
    }

    public getAtTime(time: T): TemporalNode<E, T>[] {
        let ret: TemporalNode<E, T>[] = [];

        let cell: TemporalNode<E, T>[] = this.getCellFromTime(time);
        for (let musicalEvent of cell) {
            if (time >= musicalEvent.from && time <= musicalEvent.to)
                ret.push(musicalEvent);
        }

        return ret;
    }

    public get duration(): T {
        let lastCell: TemporalNode<E, T>[] = this.cells.lastEntry()[1];
        let max: T = lastCell[0].to;
        for (let i: number = 1; i < lastCell.length; i++) {
            let c: TemporalNode<E, T> = lastCell[i];
            if (c.to > max)
                max = c.to;
        }
        return max;
    }

    public get nodes(): TemporalNode<E, T>[] {
        return this._nodes;
    }

    public removeAtTime(time: T): void {
        let cell: TemporalNode<E, T>[] = this.getCellFromTime(time);
        for (let i = 0; i < cell.length; i++) {
            let c: TemporalNode<E, T> = cell[i];
            if (c.interval.contains(time)) {
                cell.splice(i, 1);

                let indexEvents = this._nodes.indexOf(c);
                this._nodes.splice(indexEvents, 1);
                i--;
            }
        }
    }

    public get cellSize(): T {
        return this._cellSize;
    }
}