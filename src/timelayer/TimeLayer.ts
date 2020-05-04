import { Time } from 'tempo/Time';

export interface TimeLayer<ARRAY, T extends Time> {
    length: T;

    removeAtTime(time: T): void;
}
