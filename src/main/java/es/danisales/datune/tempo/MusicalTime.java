package es.danisales.datune.tempo;

import com.google.common.collect.ImmutableList;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

public class MusicalTime implements Time<MusicalTime> {
	@SuppressWarnings("WeakerAccess")
	public static final MusicalTime MAXIMA = new MusicalTime(8, true);
	public static final MusicalTime LONGA = new MusicalTime(4, true);
	public static final MusicalTime DOUBLE = new MusicalTime(2, true);
	public static final MusicalTime WHOLE = new MusicalTime(1, true);
	public static final MusicalTime HALF = new MusicalTime(1/2.0d, true);
	public static final MusicalTime QUARTER = new MusicalTime(1/4.0d, true);
	@SuppressWarnings("WeakerAccess")
	public static final MusicalTime EIGHTH = new MusicalTime(1/8.0d, true);
	@SuppressWarnings("WeakerAccess")
	public static final MusicalTime SIXTEENTH = new MusicalTime(1/16.0d, true);
	@SuppressWarnings("WeakerAccess")
	public static final MusicalTime THIRTYSECOND = new MusicalTime(1/32.0d, true);
	public static final MusicalTime SIXTYFOURTH = new MusicalTime(1/64.0d, true);

	public static final MusicalTime ZERO = new MusicalTime(0, true);

	double val;
	private boolean immutable;

    MusicalTime(double n, boolean immutable) {
		val = n;
		this.immutable = immutable;
	}

	private static List<MusicalTime> timeImmutableList = ImmutableList.copyOf(Arrays.asList(ZERO, MAXIMA, LONGA, DOUBLE, WHOLE, HALF, QUARTER, EIGHTH, SIXTEENTH, THIRTYSECOND, SIXTYFOURTH));

	public static List<MusicalTime> values() {
    	return timeImmutableList;
	}

	public static @NonNull MusicalTime from(double v) {
		checkArgument(v >= 0);
    	return new MusicalTime(v, false);
	}

	private double getValue() {
    	return val;
	}

	@Override
	public MusicalTime add(@NonNull MusicalTime musicalTime) {
		checkState(!immutable);
		val += musicalTime.getValue();

		return this;
	}

	@Override
	public MusicalTime sub(@NonNull MusicalTime musicalTime) {
		checkState(!immutable);
		val -= musicalTime.getValue();

		return this;
	}

	@SuppressWarnings("MethodDoesntCallSuperMethod")
	@Override
	public MusicalTime clone() {
		return new MusicalTime(val, false);
	}

	@Override
	public int getDiv(@NonNull MusicalTime cellSize) {
		return (int)Math.floor(getValue() / cellSize.getValue());
	}

	@Override
	public boolean isBetween(MusicalTime a, MusicalTime b) {
		return getValue() >= a.getValue() && getValue() < b.getValue();
	}

	@Override
	public int compareTo(@NonNull MusicalTime o) {
		return Double.compare(getValue(), o.getValue());
	}

	@Override
	public MusicalTime mult(int n) {
		checkState(!immutable);
		val *= n;

		return this;
	}

	public MusicalTime dotted() {
		checkState(!immutable);
		val *= 1.5;

		return this;
	}

	@Override
	public boolean equals(Object o) {
		if ( !(o instanceof MusicalTime))
			return false;

		MusicalTime musicalTime = (MusicalTime)o;

		return Math.abs(getValue() - musicalTime.getValue()) <= MusicalTime.SIXTYFOURTH.getValue()/2;
	}

	@Override
	public String toString() {
		double value = getValue();

		return Double.toString(value / MusicalTime.QUARTER.getValue());
	}
}
