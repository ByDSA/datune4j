import { Chromatic } from "../degrees/Chromatic";
import { Ratio } from "./ratios/Ratio";
import { RatioFrac } from "./ratios/RatioFrac";
import { RatioNumber } from "./ratios/RatioNumber";
import { RatioPow2Frac } from "./ratios/RatioPow2Frac";

export class IntervalPitch {
    public static UNISON: IntervalPitch;
    public static OCTAVE: IntervalPitch;
    public static CENT: IntervalPitch;

    private constructor(private _ratio: Ratio) {
    }

    public static from(ratio: Ratio) {
        return new IntervalPitch(ratio);
    }

    get ratio(): Ratio {
        return this._ratio;
    }

    get cents(): number {
        if (this._ratio instanceof RatioPow2Frac)
            return (<RatioPow2Frac>this.ratio).cents;
        else
            return 1200 * Math.log2(this._ratio.value);
    }

    hashCode() {
        return this.ratio.value;
    }

    private static initialize() {
        this.UNISON = this.from(RatioNumber.from(1));
        this.CENT = this.from(RatioPow2Frac.fromCents(1));
        this.COMMAS.PYTHAGOREAN_COMMA = this.from(RatioFrac.from(531441, 524288));
        this.OCTAVE = this.from(RatioNumber.from(2));

        this.ET12.QUARTER_TONE = this.from(RatioPow2Frac.from(1, Chromatic.NUMBER * 2));
        this.ET12.SEMITONE = this.from(RatioPow2Frac.fromCents(100));
        this.ET12.MINOR_SECOND = this.ET12.SEMITONE;
        this.ET12.MAJOR_SECOND = this.from(RatioPow2Frac.fromCents(200));
        this.ET12.TONE = this.ET12.MAJOR_SECOND;
        this.ET12.MINOR_THIRD = this.from(RatioPow2Frac.fromCents(300));
        this.ET12.MAJOR_THIRD = this.from(RatioPow2Frac.fromCents(400));
        this.ET12.PERFECT_FOURTH = this.from(RatioPow2Frac.fromCents(500));
        this.ET12.TRITONE = this.from(RatioPow2Frac.fromCents(600));
        this.ET12.PERFECT_FIFTH = this.from(RatioPow2Frac.fromCents(700));
        this.ET12.MINOR_SIXTH = this.from(RatioPow2Frac.fromCents(800));
        this.ET12.MAJOR_SIXTH = this.from(RatioPow2Frac.fromCents(900));
        this.ET12.MINOR_SEVENTH = this.from(RatioPow2Frac.fromCents(1000));
        this.ET12.MAJOR_SEVENTH = this.from(RatioPow2Frac.fromCents(1100));

        this.PYTHAGOREAN.DIMINISHED_SECOND = this.from(RatioFrac.from(524288, 531441)); // lower than 1
        this.PYTHAGOREAN.COMMA = this.from(RatioFrac.from(531441, 524288)); // lower than 1
        this.PYTHAGOREAN.MINOR_SECOND = this.from(RatioFrac.from(256, 243))
        this.PYTHAGOREAN.AUGMENTED_UNISON = this.from(RatioFrac.from(2187, 2048))
        this.PYTHAGOREAN.DIMINISHED_THIRD = this.from(RatioFrac.from(65536, 59049));
        this.PYTHAGOREAN.MAJOR_SECOND = this.from(RatioFrac.from(9, 8));
        this.PYTHAGOREAN.MINOR_THIRD = this.from(RatioFrac.from(32, 27));
        this.PYTHAGOREAN.AUGMENTED_SECOND = this.from(RatioFrac.from(19683, 16384));
        this.PYTHAGOREAN.DIMINISHED_FOURTH = this.from(RatioFrac.from(8192, 6561));
        this.PYTHAGOREAN.MAJOR_THIRD = this.from(RatioFrac.from(81, 64));
        this.PYTHAGOREAN.PERFECT_FOURTH = this.from(RatioFrac.from(4, 3));
        this.PYTHAGOREAN.AUGMENTED_THIRD = this.from(RatioFrac.from(177147, 131072));
        this.PYTHAGOREAN.DIMINISHED_FIFTH = this.from(RatioFrac.from(1024, 729));
        this.PYTHAGOREAN.AUGMENTED_FOURTH = this.from(RatioFrac.from(729, 512));
        this.PYTHAGOREAN.TRITONE = this.PYTHAGOREAN.DIMINISHED_FIFTH;
        this.PYTHAGOREAN.DIMINISHED_SIXTH = this.from(RatioFrac.from(262144, 177147));
        this.PYTHAGOREAN.PERFECT_FIFTH = this.from(RatioFrac.from(3, 2));
        this.PYTHAGOREAN.MINOR_SIXTH = this.from(RatioFrac.from(128, 81));
        this.PYTHAGOREAN.AUGMENTED_FIFTH = this.from(RatioFrac.from(6561, 4096));
        this.PYTHAGOREAN.DIMINISHED_SEVENTH = this.from(RatioFrac.from(32768, 19683));
        this.PYTHAGOREAN.MAJOR_SIXTH = this.from(RatioFrac.from(27, 16));
        this.PYTHAGOREAN.MINOR_SEVENTH = this.from(RatioFrac.from(16, 9));
        this.PYTHAGOREAN.AUGMENTED_SIXTH = this.from(RatioFrac.from(59049, 32768));
        this.PYTHAGOREAN.DIMINISHED_OCTAVE = this.from(RatioFrac.from(4096, 2187));
        this.PYTHAGOREAN.MAJOR_SEVENTH = this.from(RatioFrac.from(243, 128));
        this.PYTHAGOREAN.AUGMENTED_SEVENTH = this.from(RatioFrac.from(531441, 262144));

        IntervalPitch.JUST.QUARTER_TONE = this.from(RatioFrac.from(246, 239));
        this.JUST.MINOR_SECOND = this.from(RatioFrac.from(16, 15));
        this.JUST.SEMITONE = this.JUST.MINOR_SECOND;
        this.JUST.DIMINISHED_THIRD = this.from(RatioFrac.from(256, 225));
        this.JUST.MAJOR_TONE = this.PYTHAGOREAN.MAJOR_SECOND;
        this.JUST.MINOR_TONE = this.from(RatioFrac.from(10, 9));
        this.JUST.AUGMENTED_SECOND = this.from(RatioFrac.from(75, 64));
        this.JUST.MINOR_THIRD = this.from(RatioFrac.from(6, 5));
        this.JUST.MAJOR_THIRD = this.from(RatioFrac.from(5, 4));
        this.JUST.AUGMENTED_THIRD = this.from(RatioFrac.from(125, 96));
        this.JUST.PERFECT_FOURTH = this.PYTHAGOREAN.PERFECT_FOURTH;
        this.JUST.AUGMENTED_FOURTH = this.from(RatioFrac.from(45, 32));
        this.JUST.DIMINISHED_FIFTH = this.from(RatioFrac.from(36, 25));
        this.JUST.TRITONE = this.from(RatioFrac.from(64, 45));
        this.JUST.PERFECT_FIFTH = this.PYTHAGOREAN.PERFECT_FIFTH;
        this.JUST.AUGMENTED_FIFTH = this.from(RatioFrac.from(25, 16));
        this.JUST.MINOR_SIXTH = this.from(RatioFrac.from(8, 5));
        this.JUST.MAJOR_SIXTH = this.from(RatioFrac.from(5, 3));
        this.JUST.DIMINISHED_SEVENTH = this.from(RatioFrac.from(128, 75));
        this.JUST.AUGMENTED_SIXTH = this.from(RatioFrac.from(125, 72));
        this.JUST.AUGMENTED_SIXTH2 = this.from(RatioFrac.from(225, 128));
        this.JUST.MINOR_SEVENTH_SMALL = this.PYTHAGOREAN.MINOR_SEVENTH;
        this.JUST.MINOR_SEVENTH_GREATER = this.from(RatioFrac.from(9, 5));
        this.JUST.MAJOR_SEVENTH = this.from(RatioFrac.from(15, 8));
        this.JUST.AUGMENTED_SEVENTH = this.from(RatioFrac.from(125, 64));
        this.JUST.PERFECT_TWELFTH = this.from(RatioFrac.from(3, 1));
    }
}

export namespace IntervalPitch {
    export class COMMAS {
        public static SYNTONIC_COMMA: IntervalPitch;
        public static PYTHAGOREAN_COMMA: IntervalPitch;
    }

    export class JUST {
        static QUARTER_TONE: IntervalPitch;
        static MINOR_SECOND: IntervalPitch;
        static SEMITONE: IntervalPitch;
        static DIMINISHED_THIRD: IntervalPitch;
        static MAJOR_TONE: IntervalPitch;
        static MINOR_TONE: IntervalPitch;
        static AUGMENTED_SECOND: IntervalPitch;
        static MINOR_THIRD: IntervalPitch;
        static MAJOR_THIRD: IntervalPitch;
        static AUGMENTED_THIRD: IntervalPitch;
        static PERFECT_FOURTH: IntervalPitch;
        static AUGMENTED_FOURTH: IntervalPitch;
        static DIMINISHED_FIFTH: IntervalPitch;
        static TRITONE: IntervalPitch;
        static PERFECT_FIFTH: IntervalPitch;
        static AUGMENTED_FIFTH: IntervalPitch;
        static MINOR_SIXTH: IntervalPitch;
        static MAJOR_SIXTH: IntervalPitch;
        static DIMINISHED_SEVENTH: IntervalPitch;
        static AUGMENTED_SIXTH: IntervalPitch;
        static AUGMENTED_SIXTH2: IntervalPitch;
        static MINOR_SEVENTH_SMALL: IntervalPitch;
        static MINOR_SEVENTH_GREATER: IntervalPitch;
        static MAJOR_SEVENTH: IntervalPitch;
        static AUGMENTED_SEVENTH: IntervalPitch;
        static PERFECT_TWELFTH: IntervalPitch;
    };

    export class ET12 {
        static QUARTER_TONE: IntervalPitch;
        static SEMITONE: IntervalPitch;
        static MINOR_SECOND: IntervalPitch;
        static MAJOR_SECOND: IntervalPitch;
        static TONE: IntervalPitch;
        static MINOR_THIRD: IntervalPitch;
        static MAJOR_THIRD: IntervalPitch;
        static PERFECT_FOURTH: IntervalPitch;
        static TRITONE: IntervalPitch;
        static PERFECT_FIFTH: IntervalPitch;
        static MINOR_SIXTH: IntervalPitch;
        static MAJOR_SIXTH: IntervalPitch;
        static MINOR_SEVENTH: IntervalPitch;
        static MAJOR_SEVENTH: IntervalPitch;
    };

    export class PYTHAGOREAN {
        static COMMA: IntervalPitch;
        static AUGMENTED_UNISON: IntervalPitch;
        static DIMINISHED_SECOND: IntervalPitch;
        static MINOR_SECOND: IntervalPitch;
        static DIMINISHED_THIRD: IntervalPitch;
        static MAJOR_SECOND: IntervalPitch;
        static MINOR_THIRD: IntervalPitch;
        static AUGMENTED_SECOND: IntervalPitch;
        static DIMINISHED_FOURTH: IntervalPitch;
        static MAJOR_THIRD: IntervalPitch;
        static PERFECT_FOURTH: IntervalPitch;
        static AUGMENTED_THIRD: IntervalPitch;
        static DIMINISHED_FIFTH: IntervalPitch;
        static TRITONE: IntervalPitch;
        static AUGMENTED_FOURTH: IntervalPitch;
        static DIMINISHED_SIXTH: IntervalPitch;
        static PERFECT_FIFTH: IntervalPitch;
        static MINOR_SIXTH: IntervalPitch;
        static AUGMENTED_FIFTH: IntervalPitch;
        static DIMINISHED_SEVENTH: IntervalPitch;
        static MAJOR_SIXTH: IntervalPitch;
        static MINOR_SEVENTH: IntervalPitch;
        static AUGMENTED_SIXTH: IntervalPitch;
        static DIMINISHED_OCTAVE: IntervalPitch;
        static MAJOR_SEVENTH: IntervalPitch;
        static AUGMENTED_SEVENTH: IntervalPitch;
    }
}