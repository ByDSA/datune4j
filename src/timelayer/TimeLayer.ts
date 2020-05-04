import { Time } from 'tempo/Time';

export interface TimeLayer<C, T extends Time> {
    get(time: T): C;
    getLength(): T;

    remove(time: T): void;
}
