import { Time } from '../tempo/Time';
import { Interval } from '../utils/Interval';

export interface TimeLayer<ARRAY, T extends Time> {
    duration: T;

    removeAtTime(time: T): void;
    // TODO: removeAtInterval(intervalTime: Interval<T>): void;
}
