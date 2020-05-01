import { ImmutablesCache } from '../common/ImmutablesCache';
import { Diatonic } from '../degrees/Diatonic';
import { IntervalSymbolic } from './Interval';

export class IntervalDiatonic implements IntervalSymbolic {
    public static UNISON;
    public static SECOND;
    public static THIRD;
    public static FOURTH;
    public static FIFTH;
    public static SIXTH;
    public static SEVENTH;
    public static OCTAVE;
    public static NINTH;
    public static TENTH;
    public static ELEVENTH;
    public static TWELFTH;
    public static THIRTEENTH;
    public static FOURTEENTH;
    public static FIFTEENTH;

    private static immutablesCache = new ImmutablesCache<IntervalDiatonic, number>(
        function (num: number): string {
            return "" + num;
        },
        function (intervalDiatonic: IntervalDiatonic): number {
            return intervalDiatonic.number;
        },
        function (num: number): IntervalDiatonic {
            return new IntervalDiatonic(num);
        }
    );

    private constructor(private _number: number) {
    }

    public static from(num: number) {
        if (num < 0)
            num = num % Diatonic.NUMBER + Diatonic.NUMBER;
        return IntervalDiatonic.immutablesCache.getOrCreate(num);
    }

    get number(): number {
        return this._number;
    }

    public toString(): string {
        switch (this) {
            case IntervalDiatonic.UNISON: return "UNISON";
            case IntervalDiatonic.SECOND: return "SECOND";
            case IntervalDiatonic.THIRD: return "THIRD";
            case IntervalDiatonic.FOURTH: return "FOURTH";
            case IntervalDiatonic.FIFTH: return "FIFTH";
            case IntervalDiatonic.SIXTH: return "SIXTH";
            case IntervalDiatonic.SEVENTH: return "SEVENTH";
            case IntervalDiatonic.OCTAVE: return "OCTAVE";
            case IntervalDiatonic.NINTH: return "NINTH";
            case IntervalDiatonic.TENTH: return "TENTH";
            case IntervalDiatonic.ELEVENTH: return "ELEVENTH";
            case IntervalDiatonic.TWELFTH: return "TWELFTH";
            case IntervalDiatonic.THIRTEENTH: return "THIRTEENTH";
            case IntervalDiatonic.FOURTEENTH: return "FOURTEENTH";
            case IntervalDiatonic.FIFTEENTH: return "FIFTEENTH";
        }

        return "IntervalDiatonic: " + this.number;
    }

    private static initialize() {
        this.UNISON = IntervalDiatonic.from(0);
        this.SECOND = IntervalDiatonic.from(1);
        this.THIRD = IntervalDiatonic.from(2);
        this.FOURTH = IntervalDiatonic.from(3);
        this.FIFTH = IntervalDiatonic.from(4);
        this.SIXTH = IntervalDiatonic.from(5);
        this.SEVENTH = IntervalDiatonic.from(6);
        this.OCTAVE = IntervalDiatonic.from(7);
        this.NINTH = IntervalDiatonic.from(8);
        this.TENTH = IntervalDiatonic.from(9);
        this.ELEVENTH = IntervalDiatonic.from(10);
        this.TWELFTH = IntervalDiatonic.from(11);
        this.THIRTEENTH = IntervalDiatonic.from(12);
        this.FOURTEENTH = IntervalDiatonic.from(13);
        this.FIFTEENTH = IntervalDiatonic.from(14);
    }
}